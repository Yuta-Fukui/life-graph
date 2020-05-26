<template>
  <v-app id="top">
    <Header />
    <v-container>
      <!-- <p v-if="login"> -->
      <v-row style="height: 450px;" justify="center" align-content="center">
        <v-col cols="12" sm="6" md="4">
          <v-card
            id="topSearchAft"
            class="mx-auto"
            max-width="344"
            outlined large
            color="#26A69A"
          >
            <v-list-item three-line>
              <v-list-item-content width="404px">
                <v-list-item-title outlined large color="#FFFFFF" class="white--text">
                  検索
                </v-list-item-title>
                <v-list-item-subtitle class="white--text">
                  希望の人生グラフを見ることができます。
                </v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
            <v-card-actions>
              <v-btn class="teal--text" to="/life-graph/lists">
                検索する
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
        <v-col cols="12" sm="6" md="4">
          <v-card
            id="topEntry"
            class="mx-auto"
            max-width="344"
            outlined
          >
            <v-list-item three-line>
              <v-list-item-content>
                <v-list-item-title id="entryTitle" class="#777575--text">
                  登録または編集
                </v-list-item-title>
                <v-list-item-subtitle id="entrySubtitle" class="#777575--text">
                  人生グラフを作成、グラフの項目の追加・訂正を行えます。
                </v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
            <v-card-actions>
              <v-btn id="entryBtn" class="white--text" color="#26A69A" to="/new">
                登録編集する
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
      <v-row justify="center" class="mb-10">
        <v-col cols="12" sm="12" md="8" lg="6">
          <v-card class="pa-10">
            <Chart />
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
import Header from '../components/Header.vue'
// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'
import Chart from '../chart/Chart'
// export default {
//   name: 'Home',
//   components: {
//     HelloWorld
//   },
export default {
  name: 'Top',
  components: {
    Chart,
    Header
  }
}

//   created () {
//     this.$store.dispatch('fetchLogin')
//   }
// }
</script>
