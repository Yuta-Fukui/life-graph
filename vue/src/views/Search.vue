<template>
  <v-app id="search">
    <v-container>
      <!-- 検索欄 -->
      <v-row>
        <v-col cols="12" sm="6" md="3">
          <v-text-field
            label="ユーザーから探す"
            outlined
          />
        </v-col>
        <v-spacer />
        <v-col cols="12" sm="4">
          <v-overflow-btn
            class="my-2"
            :items="searchByData"
            label="更新日時から検索"
          />
        </v-col>
        <!-- <v-col cols="4">
          <v-select
            v-model="searchByData"
            item-text="dataItem"
            item-value="dataValue"
            :items="searchData"
            return-object
            :menu-props="{ maxHeight: '400' }"
            label="更新日時から検索"
            outlined
          />
        </v-col> -->
      </v-row>
      <router-link to="/reference">
        参照画面
      </router-link>
      <!-- 検索結果 -->
      <v-data-table
        :headers="headers"
        :items="searchResult"
        :page.sync="page"
        class="elevation-1"
        @page-count="pageCount = $event"
      >
        <template v-slot:top>
          <v-toolbar max-width="1200" max-height="50"
                     class="mx-auto" color="#26A69A"
                     dark
                     outlined
          >
            <v-toolbar-title>検索結果</v-toolbar-title>
            <v-spacer />
          </v-toolbar>
        </template>
        <div class="text-center pt-2">
          <v-pagination v-model="page" :length="pageCount" />
        </div>
        <!-- </v-toolbar-title>
        </v-app-bar> -->

        <!-- <v-container> -->
        <!-- <v-row dense>
            <v-col cols="12">
              <v-card
                color="#385F73"
                dark
              >
                <v-card-title class="headline">
                  Unlimited music now
                </v-card-title>

                <v-card-subtitle>Listen to your favorite artists and albums whenever and wherever, online and offline.</v-card-subtitle>

                <v-card-actions>
                  <v-btn text>
                    Listen Now
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-col>

            <v-col
              v-for="(item, i) in items"
              :key="i"
              cols="12"
            >
              <v-card
                :color="item.color"
                dark
              >
                <div class="d-flex flex-no-wrap justify-space-between">
                  <div>
                    <v-card-title
                      class="headline"
                      v-text="item.title"
                    />

                    <v-card-subtitle v-text="item.artist" />
                  </div>

                  <v-avatar
                    class="ma-3"
                    size="125"
                    tile
                  >
                    <v-img :src="item.src" />
                  </v-avatar>
                </div>
              </v-card>
            </v-col>
          </v-row> -->
        <!-- </v-container> -->
      </v-data-table>
    <!-- <SearchIput />
    <SearchResults /> -->
    </v-container>
  </v-app>
</template>

<script>
export default {
  dialog: false,
  data: () => ({
    headers: [
      {
        text: 'ユーザー',
        align: 'start',
        sortable: false,
        value: 'name'
      },
      {
        text: 'グラフタイトル',
        align: 'center',
        sortable: false,
        value: 'title'
      },
      { text: '作成日時', align: 'center', value: 'created_at' },
      { text: '更新日時', align: 'center', value: 'updated_at' }
    ]
  }),
  searchResult: [
    {
      name: '名前',
      title: 'タイトル',
      created_at: '2020.05.18',
      updated_at: '2020.05.20'
    }],
  searchByData: [
    { label: '1日前' },
    { label: '1週間前' },
    { label: '1ヶ月前' },
    { label: 'それより前' }
  ]
}
</script>
