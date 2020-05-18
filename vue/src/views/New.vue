<template>
  <v-container>
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
          <v-divider
            class="mx-4"
            inset
            vertical
          />
          <v-spacer />
          <!-- v-dialogでモーダル表示部分の設定 -->
          <v-dialog v-model="dialog" max-width="500px">
            <!-- v-slot:activator={on}でユーザーがモーダル画面を表示 -->
            <template v-slot:activator="{ on }">
              <v-btn
                class="white--text"
                large
                color="#64D8CB"
                v-on="on"
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
                  <v-row>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="editedItem.age"
                        label="年齢"
                      />
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="editedItem.score"
                        label="スコア"
                      />
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="editedItem.comment"
                        label="コメント"
                      />
                    </v-col>
                    <v-col cols="12" sm="6" md="4">
                      <v-text-field
                        v-model="editedItem.title"
                        label="タイトル"
                      />
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
  </v-container>
</template>

<script>
export default {
  dialog: false,
  data: () => ({
    // データテーブルのカラムとvalue名
    headers: [
      {
        text: '年齢',
        align: 'start',
        value: 'age'
      },
      { text: 'スコア', value: 'score' },
      { text: 'コメント', value: 'comment' },
      { text: 'タイトル', value: 'title' },
      { text: '編集', value: 'actions', sortable: false }
    ],
    // chartSets部分にage,score,title,commentの配列を渡す
    // 以下の型でstoreでデータ管理
    chartSets: [
      // {
      //   headersets部分で定義したvalue
      //   age: 20,
      //   score: 12,
      //   comment: 'コメント',
      //   title: 'タイトル'
      // }
    ],
    editedIndex: -1,
    editedItem: {
      age: 0,
      score: 0,
      comment: '',
      title: ''
    },
    defaultItem: {
      age: 0,
      score: 0,
      comment: '',
      title: ''
    }
  }),
  computed: {
    // モーダル表示タイトルを条件分岐で変更。インデックス数値が-1だった場合追加する、1以上の場合（すでに登録されている)編集すると表示される
    formTitle () {
      return this.editedIndex === -1 ? '追加する' : '編集する'
    }
  },
  watch: {
    dialog (val) {
      val || this.close()
    }
  },
  methods: {
    // モーダルのフォームデフォルトに登録済みのデータを表示
    editItem (item) {
      this.editedIndex = this.chartSets.indexOf(item)
      this.editedItem = Object.assign({}, item)
      // storeのデータを書き込むdispatchでstoreのアクションを呼び込む
      // const editedItems = this.editedItem
      // this.$store.dispatch('chart/edit,editedItems)
      this.dialog = true
      // storeのデータを書き込むdispatchでstoreのアクションを呼び込む
    },
    // index番号と一致するレコードの削除
    deleteItem (item) {
      const index = this.chartSets.indexOf(item)
      confirm('本当に削除しますか？') && this.desserts.splice(index, 1)
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
      if (this.editedIndex > -1) {
        Object.assign(this.chartSets[this.editedIndex], this.editedItem)
      // それ以外の新規追加の場合は、editedItemをpushする
      } else {
        this.chartSets.push(this.editedItem)
      }
      this.close()
    }
  }
}
</script>
