<script>
import { Line } from 'vue-chartjs'

export default {
  name: 'LifeChart',
  // propsとかで登録画面の情報を持ってくるかデータベースからデータ持ってこないとダメよね？？
  extends: Line,
  data () {
    return {
      data: {
        // ここに年齢が入るからlabelsの中は空にする
        labels: [],
        datasets: [
          {
            // ここにスコアが入るからlabelsの中は空にする
            data: [],
            borderColor: '#26A69A',
            fill: false,
            lineTension: 0.4
          }
        ]
      },
      options: {
        tooltips: {
          // ツールチップのデフォルト設定の無効化
          enabled: false,
          // カスタム
          custom: []
        },
        // 凡例消す
        legend: false,
        scales: {
          xAxes: [{
          //   scaleLabel: {
          //     display: true
          //   },
            gridLines: {
              // 縦線消す
              display: false
            },
            ticks: {
              display: false,
              beiginAtZero: true
            }
          }],
          yAxes: [{
            gridLines: {
              // zeroLineを残すため。理想は他の線はない状態？？要確認
              display: false,
              zeroLineColor: 'rgba(255, 99, 132, 1)'
            },
            ticks: {
              suggestedMax: 100,
              suggestedMin: -100
              // display: true
            }
          }]
        }
      }
    }
  },
  mounted () {
    this.setLabels()
    this.setData()
    this.setComments()
    this.renderChart(this.data, this.options)
  },
  methods: {
    setLabels () {
      //  agesに配列を渡す
      const ages = []
      // stageからcontents配列を呼び込みagesにcontentsのインデックス順にageを渡す
      this.$store.state.chart.contents.map((content) => {
        ages.push(content.age)
      })
      // labelsの中に代入する
      this.data.labels = ages
    },
    setData () {
      const scores = []
      this.$store.state.chart.contents.map((content) => {
        scores.push(content.score)
      })
      this.data.datasets[0].data = scores
    },
    setComments () {
      const comments = []
      this.$store.state.chart.contents.map((content) => {
        // commentsにageとcommentのオブジェクトを入れる
        comments.push({ age: content.age, comment: content.comment })
      })
      this.options.tooltips.custom = function (tooltipModel) {
        // ツールチップ要素の指定
        var tooltipEl = document.getElementById('chartjs-tooltip')
        // 最初のレンダリング時に要素を作成する
        if (!tooltipEl) {
          tooltipEl = document.createElement('div')
          tooltipEl.id = 'chartjs-tooltip'
          tooltipEl.innerHTML = '<table></table>'
          // 対象のノードにtooltipEl要素を追加
          document.body.appendChild(tooltipEl)
        }
        // ツールチップがなければ非表示
        if (tooltipModel.opacity === 0) {
          tooltipEl.style.opacity = 0
          return
        }
        function getBody (bodyItem) {
          return bodyItem.lines
        }
        // テキストを設定する
        if (tooltipModel.body) {
          var titleLines = tooltipModel.title
          var bodyLines = tooltipModel.body.map(getBody)
          var innerHtml = '<thead>'
          // x軸の値を返してくれる
          titleLines.forEach(function (age) {
            // 配列であるcommnetsのなかのageが、function内でループしているageと=になる時のcommentを見てくる
            var comment = comments.find(comment => comment.age === age).comment
            innerHtml += '<tr><th>' + age + '歳' + '</th></tr>'
            // innerHtml += '</thead><tbody>'
            bodyLines.forEach(function (body, i) {
              var colors = tooltipModel.labelColors[i]
              var style = 'background:' + colors.backgroundColor
              style += '; border-color:' + colors.borderColor
              style += '; border-width: 2px'
              var span = '<span style="' + style + '"></span>'
              // '<tr><td>' は多分改行
              if (comment) {
                innerHtml += '<tr><td>' + span + '満足度：' + body + ' ポイント' + '</td></tr>' + '内容：' + comment
              } else {
                innerHtml += '<tr><td>' + span + '満足度：' + body + ' ポイント' + '</td></tr>'
              }
            })
          })
          innerHtml += '</tbody>'
          var tableRoot = tooltipEl.querySelector('table')
          tableRoot.innerHTML = innerHtml
        }
        // 要素の寸法と、そのビューポートに対する位置
        var position = this._chart.canvas.getBoundingClientRect()
        // 表示、配置、およびフォントスタイルの設定
        tooltipEl.style.opacity = 1
        tooltipEl.style.position = 'absolute'
        tooltipEl.style.left = position.left + window.pageXOffset + tooltipModel.caretX + 'px'
        tooltipEl.style.top = position.top + window.pageYOffset + tooltipModel.caretY + 'px'
        tooltipEl.style.fontFamily = tooltipModel._bodyFontFamily
        tooltipEl.style.fontSize = tooltipModel.bodyFontSize + 'px'
        tooltipEl.style.fontStyle = tooltipModel._bodyFontStyle
        tooltipEl.style.padding = tooltipModel.yPadding + 'px ' + tooltipModel.xPadding + 'px'
        tooltipEl.style.pointerEvents = 'none'
      }
    }
  }
}
</script>
