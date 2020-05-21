<template>
  <v-app id="search">
    <Header />
    <br>
    <v-card
      width="1200"
      class="mx-auto"
    >
      <v-row>
        <v-col cols="12" sm="6" md="3">
          <v-card-text>
            <v-autocomplete
              v-model="model"
              :items="items"
              :loading="isLoading"
              :search-input.sync="search"
              color="white"
              hide-no-data
              hide-selected
              item-text="Description"
              item-value="API"
              label="検索"
              placeholder="ここから入力できます"
              prepend-icon="mdi-database-search"
              return-object
            />
          </v-card-text>
        </v-col>
        <v-spacer />
        <v-col cols="4" sm="4">
          <v-card-text>
            <vue-daterange-picker
              dates-format="YYYY/MM/DD"
              format="YYYY/MM/DD"
              title-format="YYYY年 M月"
              :items="searchByData"
              :start-date="oneYearAgo"
              :end-date="today"
              label="更新日時から検索"
              start-place-holder=""
              end-place-holder=""
              @get-dates="getDates"
            />
          </v-card-text>
        </v-col>
      </v-row>

      <v-toolbar max-width="1200" max-height="50"
                 class="mx-auto" color="#26A69A"
                 dark
                 outlined
      >
        <v-toolbar-title>検索結果</v-toolbar-title>
        <v-spacer />
      </v-toolbar>
      <v-toolbar max-width="1200" max-height="50"
                 class="mx-auto" color="#26A69A"
                 dark
      >
        <v-row>
          <v-col>
            <v-card-text>
              ユーザー名
            </v-card-text>
          </v-col>
          <v-col>
            <v-card-text>
              グラフタイトル
            </v-card-text>
          </v-col>
          <v-col>
            <v-card-text>
              作成日時
            </v-card-text>
          </v-col>
          <v-col>
            <v-card-text>
              更新日時
            </v-card-text>
          </v-col>
        </v-row>
      </v-toolbar>
      <v-divider />
      <v-expand-transition>
        <v-content v-if="model">
          <v-card v-for="(field, i) in fields"
                  :key="i"
                  color="#26A69A"
                  dark
          >
            <v-card-title v-text="field.value" />

            <v-card-subtitle v-text="field.key" />

            <v-card-actions>
              <v-btn to="/reference">
                iii
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-content>
      </v-expand-transition>
      <v-card-actions>
        <v-spacer />
        <v-btn
          :disabled="!model"
          color="grey darken-3"
          @click="model = null"
        >
          Clear
          <v-icon right>
            mdi-close-circle
          </v-icon>
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-app>
</template>

<script>
import moment from 'moment'
import VueDaterangePicker from 'vue-daterange-picker'
import Header from '../components/Header.vue'

moment.locale('ja')

export default {
  name: 'Table',
  dialog: false,
  components: {
    VueDaterangePicker,
    Header
  },
  data: () => ({
    descriptionLimit: 60,
    entries: [],
    isLoading: false,
    model: null,
    search: null,
    e6: [],
    e7: [],
    searchByData: [
      '1日前', '1週間前', '1ヶ月前', 'それより前'
    ],
    oneYearAgo: moment().subtract(365, 'days').format('YYYY/MM/DD'),
    yesterday: moment().subtract(1, 'days').format('YYYY/MM/DD')
  }),
  computed: {
    fields () {
      if (!this.model) return []

      return Object.keys(this.model).map(key => {
        return {
          key,
          value: this.model[key] || 'n/a'
        }
      })
    },
    items () {
      return this.entries.map(entry => {
        const Description = entry.Description.length > this.descriptionLimit
          ? entry.Description.slice(0, this.descriptionLimit) + '...'
          : entry.Description

        return Object.assign({}, entry, { Description })
      })
    }
  },
  watch: {
    search (val) {
      // Items have already been loaded
      if (this.items.length > 0) return

      // Items have already been requested
      if (this.isLoading) return

      this.isLoading = true

      // Lazily load input items
    //   fetch('https://api.publicapis.org/entries')
    //     .then(res => res.json())
    //     .then(res => {
    //       const { username, updatedAt, createdAt } = res
    //       this.username = username
    //       this.updatedAt = updatedAt
    //       this.createdAt = createdAt
    //     })
    //     .catch(err => {
    //       console.log(err)
    //     })
    //     .finally(() => (this.isLoading = false))
    // }
    // },
    // methods: {
    //   getDates: (dates) => {
    //     console.log(dates) // Object {startDate: "2017-12-25T00:00:00+09:00", endDate: "2018-01-22T00:00:00+09:00"}
    //     // 取得した日付をイベントに渡す
    //   },
    //   filter (val, search) {
    //     return val === search
    //   }
    }
  }
}
</script>
