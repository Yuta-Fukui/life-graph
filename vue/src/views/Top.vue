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
            color="#E2E1E3"
          >
            <v-list-item three-line>
              <v-list-item-content width="404px">
                <v-list-item-title id="searchTitle">
                  検 索
                </v-list-item-title>
                <v-list-item-subtitle id="searchSubtitle">
                  希望の人生グラフを見ることが<br>
                  できます。
                </v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
            <v-card-actions>
              <v-btn id="searchBtn" block to="/life-graph/lists">
                検索する
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
        <v-col v-show="show" cols="12" sm="6" md="4">
          <v-card
            id="topEntry"
            class="mx-auto"
            max-width="344"
            outlined
          >
            <v-list-item three-line>
              <v-list-item-content>
                <v-list-item-title id="entryTitle">
                  登 録  または  編 集
                </v-list-item-title>
                <v-list-item-subtitle id="entrySubtitle">
                  あなたの人生グラフを<br>
                  作成できます。
                </v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
            <v-card-actions>
              <v-btn id="entryBtn" block class="white--text" color="#FF6F60" to="/new">
                作成する
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
        <!-- <v-col v-show="!show" cols="12" sm="6" md="4">
          <v-card
            id="topEdit"
            class="mx-auto"
            max-width="344"
            large color="#FFFFFF"
          >
            <v-list-item three-line>
              <v-list-item-content>
                <v-list-item-title id="editTitle">
                  編 集
                </v-list-item-title>
                <v-list-item-subtitle id="editSubtitle">
                  人生グラフの項目の追加・訂正を<br>
                  行えます。
                </v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
            <v-card-actions>
              <v-btn id="entryBtn" block class="white--text" color="#FF6F60" to="/new">
                編集する
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col> -->
      </v-row>
      <v-row justify="center" class="mb-10">
        <v-col class="mr-10" cols="12" sm="12" md="8" lg="6">
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
  },
  data: () => ({
    show: false
  }),
  computed: {
    getContents () {
      return this.$store.state.chart.contents
    }
  },
  mounted () {
    if (this.getContents) {
      this.show = !this.show
    }
  }
}

</script>
<style>
#top {
  background-color: #f4f2ec;
}

#topSearchAft,
#topEntry {
  padding: 10px 40px 20px 40px;
}

#entryTitle,
#searchTitle {
  color: #00227b;
  font-weight: bold;
  text-align: center;
}

#entrySubtitle,
#searchSubtitle {
  color: #00227b;
  text-align: center;
}

#searchBtn {
  background-color: white;
  color: #00227b;
  font-weight: bold;
  margin: 0 auto;
}

#entryBtn {
  font-weight: bold;
  margin: 0 auto;
}
</style>
