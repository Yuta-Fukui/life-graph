<template>
  <v-app id="new">
    <Header />
    <v-container id="dataTable">
      <!-- ヘッダーカラム、
      各カラムのデータ呼び出し
      奥ゆきの指定 -->
      <v-data-table
        :headers="headers"
        :items="chartSets"
        class="elevation-2"
      >
        <!-- ヘッダー部分 -->
        <template v-slot:top>
          <v-toolbar flat color="white">
            <v-toolbar-title>My Life Graph</v-toolbar-title>
            <v-spacer />
            <!-- v-dialogでモーダル表示部分の設定 -->
            <v-dialog v-model="dialog" max-width="500px">
              <!-- v-slot:activator={on}でユーザーがモーダル画面を表示 -->
              <template v-slot:activator="{ on }">
                <v-btn
                  id="add"
                  class="white--text"
                  large
                  color="#FF6F60"
                  v-on="on"
                  @click="click"
                >
                  追加する
                </v-btn>
              </template>
              <v-card>
                <v-card-title>
                  <span class="headline">{{ formTitle }}</span>
                </v-card-title>
                <v-card-text>
                  <v-container>
                    <v-form
                      ref="form"
                    >
                      <v-row>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field
                            v-model="editedItem.age"
                            label="年齢"
                            :rules="[required,max,min_age]"
                          />
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field
                            v-model="editedItem.score"
                            label="スコア"
                            :rules="[required,max,min] "
                          />
                        </v-col>
                        <v-col cols="12" sm="6" md="4">
                          <v-text-field
                            v-model="editedItem.comment"
                            label="コメント"
                          />
                        </v-col>
                      </v-row>
                    </v-form>
                  </v-container>
                </v-card-text>
                <v-card-actions>
                  <v-spacer />
                  <v-btn
                    color="#3949AB"
                    text @click="close"
                  >
                    キャンセル
                  </v-btn>
                  <v-btn
                    color="#3949AB"
                    text @click="save"
                  >
                    登録する
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog>
          </v-toolbar>
        </template>
        <template v-slot:item.actions="{ item }">
          <v-icon
            small
            class="mr-2"
            @click="editItem(item)"
          >
            mdi-pencil
          </v-icon>
          <v-icon
            small
            @click="deleteItem(item)"
          >
            mdi-delete
          </v-icon>
        </template>
      </v-data-table>
      <!-- <v-data-table
        :headers="titleHeader"
        :items="title"
        class="elevation-2"
      >
        <v-toolbar flat color="white">
          <v-spacer />
          <v-dialog v-model="titleDialog" max-width="500px">
            <template v-slot:activator="{ on }">
              <v-btn
                class="white-text"
                large
                color="#64D8CB"
                v-on="on"
              >
                    </v-col>
                  </v-row>
                </v-container>
              </v-card-text>
              <v-card-actions>
                <v-spacer />
                <v-btn
                  color="teal"
                  text @click="close"
                >
                  キャンセル
                </v-btn>
                <v-btn
                  color="teal"
                  text @click="save"
                >
                  登録する
                </v-btn>
              </v-card-actions>
            </v-card>
          </v-dialog>
        </v-toolbar>
      </v-data-table> -->
      <!-- <v-row justify-content-right>
        <v-col> -->
      <v-btn id="enterBtn" class="my-5"
             large
             color="gray" @click="createChart"
      >
        確定
      </v-btn>
      <!-- </v-col>
      </v-row> -->
    </v-container>
  </v-app>
</template>

<script>
import Header from '../components/Header.vue'
import axios from 'axios'

export default {
  name: 'New',
  components: {
    Header
  },
  data: () => ({
    dialog: false,
    // データテーブルのカラムとvalue名
    headers: [
      {
        text: '年齢',
        align: 'start',
        value: 'age'
      },
      {
        text: 'スコア',
        value: 'score'
      },
      { text: 'コメント', value: 'comment' },
      { text: '編集', value: 'actions', sortable: false }
    ],
    // chartSets部分にage,score,commentの配列を渡す
    // 以下の型でstoreでデータ管理
    chartSets: [],
    editedIndex: -1,
    editedItem: {
      age: 0,
      score: 0,
      comment: ''
    },
    // editedTitle: {
    //   title: ''
    // },
    defaultItem: {
      age: 0,
      score: 0,
      comment: ''
    },
    max: value => value <= 100 || 'データが一致しません',
    min_age: value => value > -1 || 'データが一致しません',
    min: value => value >= -100 || 'データが一致しません',
    // valueがない場合は右のエラー文を表示する。
    required: value => !!value || '必ず入力してください'
    // defaultTitle: 'コメントが入ります'
  }),
  computed: {
    // モーダル表示タイトルを条件分岐で変更。インデックス数値が-1だった場合追加する、1以上の場合（すでに登録されている)編集すると表示される
    formTitle () {
      return this.editedIndex === -1 ? '追加する' : '編集する'
    },
    showContents () {
      return this.$store.state.chart.contents
    }
  },
  watch: {
    // dialog (val) {
    //   val || this.close()
    // },
    showContents (newContents) {
      this.setContents()
    }
    // setEditedItem () {
    //   this.editedItem = this.$store.stare.chart.contents
    // }
    // titleDialog (val) {
    //   val || this.titleClose()
    // }
  },
  created () {
    const userId = this.$store.state.auth.userId
    this.$store.dispatch('setContents', userId)
  },
  // mounted () {
  //   this.showContents()
  // },
  methods: {
    // モーダルのフォームデフォルトに登録済みのデータを表示
    click () {
      this.dialog = true
    },
    setContents () {
      this.chartSets = this.$store.state.chart.contents
    },
    editItem (item) {
      this.editedIndex = this.chartSets.indexOf(item)
      this.editedItem = Object.assign({}, item)
      // this.editItem = this.chartSets
      this.dialog = true
    },
    // index番号と一致するレコードの削除
    deleteItem (item) {
      // get index
      const index = this.chartSets.indexOf(item)
      // confirm('本当に削除しますか？') && this.chartSets.splice(index, 1)
      // get child_chartId
      const id = this.$store.state.chart.contents[index].id
      // get user_id to update child_chart
      const userId = this.$store.state.auth.userId
      confirm('本当に削除しますか？') && this.chartSets.splice(index, 1)
      const url = 'api/auth/' + id
      axios.delete(url, {
        id: id
      }).then(res => {
        this.$store.dispatch('updateContents', userId)
      })
    },
    // モーダルを閉じ,
    close () {
      this.dialog = false
      // editedItemの更新
      this.$nextTick(() => {
        this.editedItem = Object.assign({}, this.defaultItem)
        this.editedIndex = -1
      })
    },
    save () {
      // index番号が0以上の場合、index番号に当たるitemを変更させる
      if (this.$refs.form.validate()) {
        if (this.editedIndex > -1) {
          // 編集
          Object.assign(this.chartSets[this.editedIndex], this.editedItem)
          this.editData()
          // 新規登録
        } else {
          // this.chartSets.push(this.editedItem)
          this.saveData()
        }
        this.close()
      }
    },
    saveData () {
      // get user_id
      const userId = this.$store.state.auth.userId
      const url = '/api/auth/life_graphs'
      axios.post(url, {
        userId: userId,
        age: this.editedItem.age,
        score: this.editedItem.score,
        comment: this.editedItem.comment
      }).then(res => {
        this.$store.dispatch('updateContents', userId)
      })
    },
    editData () {
      const userId = this.$store.state.auth.userId
      const childId = this.$store.state.chart.contents[this.editedIndex].id
      const url = '/api/auth/life_graphs'
      axios.post(url, {
        userId: userId,
        id: childId,
        age: this.editedItem.age,
        score: this.editedItem.score,
        comment: this.editedItem.comment
      }).then(res => {
        this.$store.dispatch('updateContents', userId)
      })
    },
    createChart () {
    // メソッド内でconst定義している場合、thisは不要
    // setContentsをdispatchして、lifeChartを渡す。
      const userId = this.$store.state.auth.userId
      this.$store.dispatch('setContents', userId)
      this.$router.push('/top')
    }
  }
}
</script>

<style>
#new {
  background-color: #f4f2ec;
}

#dataTable{
  margin-top: 100px;
}

#add{
  font-weight:bold;
}

#enterBtn{
  font-weight:bold;
  /* margin:0 0 0 auto; */
}

.theme--light.v-btn:not(.v-btn--flat):not(.v-btn--text):not(.v-btn--outlined) {
  color: white;
  color: #3949ab;
}
</style>
