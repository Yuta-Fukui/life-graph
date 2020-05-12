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
        // ageが入る
        labels: ['A', 'B', 'C', 'D', 'E', 'F'],
        datasets: [
          {
            // ここにスコアが入るからlabelsの中は空にする
            // scoreが入る
            data: [0, 70, 40, -80, 10, 100],
            borderColor: 'rgba(255, 99, 132, 0.2)',
            fill: false,
            lineTension: 0.4
          }
        ]
      },
      options: {
        // コメントが入る予定
        tooltips: {
          callbacks: {
          }
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
              // 最大値
              suggestedMax: 100,
              // 最小値
              suggestedMin: -100
              // display: true
            }
          }]
        }
      }
    }
  },
  mounted () {
    this.renderChart(this.data, this.options)
  }
}
</script>
