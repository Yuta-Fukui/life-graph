<template>
  <v-app id="search">
    <div id="ser" />
    <Header />
    <br>
    <v-card
      width="auto"
      color="#F4F2EC"
      flat
      class="mx-10"
    >
      <v-row justify="center">
        <v-col cols="6"
               md="4" max-width="auto"
        >
          <v-card-text>
            <v-autocomplete
              v-model="model"
              :items="items"
              :loading="isLoading"
              :search-input.sync="search_2"
              color="#495183"
              background-color="#F4F2EC"
              outlined
              hide-no-data
              hide-selected
              item-text="name"
              item-value="API"
              label="検索"
              placeholder="ここから入力できます"
              prepend-icon="mdi-account-search"
              return-object
              class="ma-2"
              cache-items
              flat
              hide-details
            />
          </v-card-text>
        </v-col>
        <v-col />
        <!-- <v-col cols="3">
          <v-card-text>
            <vue-daterange-picker
              dates-format="YYYY/MM/DD"
              format="YYYY/MM/DD"
              title-format="YYYY年 M月"
              :items_2="searchByData"
              :start-date="TwoWeeksAgo"
              :end-date="Date()"
              :search-input.sync="getDates"
              start-place-holder="日時検索"
              end-place-holder=""
              large
              @get-dates="getDates"
            />
          </v-card-text>
        </v-col> -->
      </v-row>
      <v-toolbar max-width="auto" max-height="50"
                 class="mx-2" color="#495183"
                 dark
                 flat
      >
        <v-toolbar-title class="title font-weight-bold">
          検索結果
        </v-toolbar-title>
        <v-spacer />
      </v-toolbar>
      <v-toolbar max-width="auto" max-height="50"
                 class="mx-2" color="#495183"
                 dark flat
      >
        <v-row>
          <v-col>
            <v-card-text class="subtitle-2 font-weight-bold">
              ユーザー名
            </v-card-text>
          </v-col>
          <v-col>
            <v-card-text class="subtitle-2 font-weight-bold">
              作成日時
            </v-card-text>
          </v-col>
          <v-col>
            <v-card-text class="subtitle-2 font-weight-bold">
              更新日時
            </v-card-text>
          </v-col>
        </v-row>
      </v-toolbar>
      <v-divider />
      <v-expand-transition>
        <!-- <v-content v-if="model"> -->
        <v-card flat class="mx-6 mt-6" height="60">
          <v-row v-for="(field, i) in fields"
                 :key="i"
                 color="#495183"
          >
            <v-col v-if="field.key === 'name'">
              <!-- <v-card-subtitle v-text="field.key" /> -->
              <v-card-text v-text="field.value" />
            </v-col>
            <v-col v-else-if="field.key === 'created'">
              <!-- <v-card-subtitle v-text="field.key" /> -->
              <v-card-text v-text="field.value" />
            </v-col>
            <v-col v-else-if="field.key === 'updated'">
              <!-- <v-card-subtitle v-text="field.key" /> -->
              <v-card-text v-text="field.value" />
            </v-col>
          </v-row>
          <v-row right>
            <v-col v-for="n in 3"
                   :key="n"
                   cols="sm"
            />
            <v-col />
            <!-- <v-btn to="/reference"> -->
            <v-col>
              <v-btn color="#FF625C" class="my-2 white--text" @click="reference()">
                グラフを表示する
              </v-btn>
            </v-col>
          </v-row>
        </v-card>
        <!-- </v-content> -->
        <!-- <v-toolbar>
          <li v-for="(index,j) in users" :key="j">
            <v-col v-for="(field, i) in fields2"
                   :key="i"
                   color="#26A69A"
                   dark
            >
              <v-col v-if="field[j].key === 'name'">
                iiii
              </v-col>
              <v-col v-else-if="field[j].key === 'created'">
                ooooo
                <v-card-text v-text="field[j].value" />
              </v-col>
              <v-col v-else-if="field[j].key === 'updated'">
                  ppppppppp
                <v-card-text v-text="field[j].value" />
              </v-col>
            </v-col>
            <v-card-actions>
              <v-btn @click="reference()">
                表示
              </v-btn>
            </v-card-actions>
          </li>
        </v-toolbar> -->
      </v-expand-transition>
      <v-card-actions>
        <v-spacer />
        <v-btn
          :disabled="!model"
          color="grey darken-3"
          outlined
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
import Header from '../components/Header.vue'
// import VueDaterangePicker from 'vue-daterange-picker'
moment.locale('ja')
export default {
  name: 'Table',
  dialog: false,
  components: {
    Header
    // VueDaterangePicker
  },
  data: () => ({
    descriptionLimit: 10,
    entries: [],
    isLoading: false,
    model: null,
    search_2: null,
    search_3: null,
    e6: [],
    e7: [],
    users: [],
    items_2: { name: '', created_at: '' },
    searchByData: [
      '1日前', '1週間前', '1ヶ月前', 'それより前'
    ],
    TwoWeeksAgo: moment().subtract(14, 'days').format('YYYY/MM/DD'),
    yesterday: moment().subtract(1, 'days').format('YYYY/MM/DD')
  }),
  computed: {
    fields () {
      if (!this.model) return []
      // console.log(Object.this.model)
      return Object.keys(this.model).map(key => {
        return {
          key,
          value: this.model[key] || 'n/a'
        }
      })
    },
    fields2 () {
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
        const name = entry.name.length > this.descriptionLimit
          ? entry.name.slice(0, this.descriptionLimit)
          : entry.name
        return Object.assign({}, entry, { name })
      })
    },
    items2 () {
      return this.$store.state.search.users.map(entry => {
        const name = entry.name.length > this.descriptionLimit
          ? entry.name.slice(0, this.descriptionLimit)
          : entry.name
        return Object.assign({}, entry, { name })
      })
    },
    search () {
      return this.$store.state.auth.search
    },
    loaded () {
      return this.$store.state.search.loaded
    }
  },
  watch: {
    search_2 (val) {
      // Items have already been loaded
      if (this.items.length > 0) return
      // Items have already been requested
      if (this.isLoading) return
      this.isLoading = true
      fetch('/api/auth/life-graphs')
        .then(function (response) {
          return response.json()
        })
        .then((response) => {
          this.entries = response
        })
        // .catch(err => {
        // })
        .finally(() => (this.isLoading = false))
    },
    loaded: function () {
      // const num = this.$store.state.search.NUM
      this.users = this.$store.state.search.users
    }
  },
  // mounted () {
  //   console.log(num)
  //   console.log('num')
  // },
  //   search_3 (val) {
  //     const url = '/api/auth/life-graphs2'
  //     fetch(url, this.dates)
  //       // console.log('res')
  //       // .then(res => res.json())
  //       .then(function (response) {
  //         return response.json()
  //       })
  //       .then((response) => {
  //         // const { entries } = response
  //         // this.entries = response
  //         console.log(response)
  //         // this.entries = entries
  //       })
  //       .catch(err => {
  //         console.log(err)
  //         console.log('err')
  //       })
  //       .finally(() => (this.isLoading = false))
  //   }
  // },
  methods: {
    getDates: function (dates) {
      this.$store.dispatch('schedule', { dates })
    },
    filter (val, search) {
      return val === search
    },
    reference () {
      const Id = this.model
      // this.$store.dispatch('setUserId', { Id: Id.id })
      this.$store.commit('resetContents')
      this.$store.dispatch('usersContents', Id.id)
      this.$router.push('/reference')
    }
  }
}
</script>

<style>
#search {
  background-color:#F4F2EC
}
img {
  display:none
}
.calender {
  color:#F4F2EC
}
#ser{
  padding:20px
}
</style>
