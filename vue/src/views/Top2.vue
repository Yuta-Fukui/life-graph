<template>
  <!-- ログイン前の画面 -->
  <v-app id="top">
    <v-card
      id="topSearchBef"
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title class="searchTitle">
            検索
          </v-list-item-title>
          <v-list-item-subtitle class="searchSubtitle">
            希望の人生グラフを見ることができます。
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <v-card-actions>
        <router-link to="/search">
          <v-btn class="searchBtn" text>
            検索する
          </v-btn>
        </router-link>
      </v-card-actions>
    </v-card>
    <v-card
      id="topEntry"
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <v-list-item-title id="entryTitle">
            登録
          </v-list-item-title>
          <v-list-item-subtitle id="entrySubtitle">
            人生グラフを作成できます。
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>
      <v-card-actions>
        <router-link to="/new">
          <v-btn id="entryBtn" text>
            登録する
          </v-btn>
        </router-link>
      </v-card-actions>
    </v-card>
    <!-- </p> -->
  </v-app>
</template>
