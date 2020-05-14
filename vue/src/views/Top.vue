<template>
  <v-app id="top">
    <p v-if="login">
      <v-card
        id="topSearchAft"
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
        id="topEdit"
        class="mx-auto"
        max-width="344"
        outlined
      >
        <v-list-item three-line>
          <v-list-item-content>
            <v-list-item-title id="editTitle">
              編集
            </v-list-item-title>
            <v-list-item-subtitle id="editSubtitle">
              人生グラフの項目の追加・訂正を行えます。
            </v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-card-actions>
          <router-link to="/">
            <v-btn id="editBtn" text>
              編集する
            </v-btn>
          </router-link>
        </v-card-actions>
        <div id="topChart">
          <Chart />
        </div>
      </v-card>
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
              こちらの検索ボタンから人生グラフを検索できます
            </v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-card-actions>
          <v-btn class="searchBtn" href="../views/Search.vue" text>
            検索する
          </v-btn>
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
              こちらのボタンから人生グラフを登録できます
            </v-list-item-subtitle>
          </v-list-item-content>
        </v-list-item>
        <v-card-actions>
          <v-btn id="entryBtn" text>
            登録する
          </v-btn>
        </v-card-actions>
      </v-card>
    </p>
  </v-app>
</template>

<script>

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
    Chart
  },

  data: () => ({
    //
  })
}

//   created () {
//     this.$store.dispatch('fetchLogin')
//   }
// }
</script>
<style>
#topChart {
  position:absolute;
  top:400px;
  right:200px;
  width: 300px;
  height: 300px;
  margin: 0 auto;
}

#topSearchBef   {
  position: absolute;
  width: 404px;
  height: 264px;
  left: 263px;
  top: 231px;

  background: #26A69A;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 2px;
}

#topSearchAft   {
  position: absolute;
  width: 404px;
  height: 264px;
  left: 263px;
  top: 231px;

  background: #26A69A;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 2px;
}

#topEntry   {
  position: absolute;
  width: 404px;
  height: 264px;
  left: 769px;
  top: 231px;

  background: #FFFFFF;
  border: 2px solid #26A69A;
  box-sizing: border-box;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 2px;
}

#topEdit    {
  position: absolute;
  width: 404px;
  height: 264px;
  left: 769px;
  top: 231px;

  background: #FFFFFF;
  border: 2px solid #26A69A;
  box-sizing: border-box;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  border-radius: 2px;
}

.searchTitle  {
  position: absolute;
  width: 139px;
  height: 42px;
  left: 0px;
  top: 20px;

  font-style: normal;
  font-weight: bold;
  font-size: 36px;
  line-height: 42px;

  color: #FFFFFF;
}

#entryTitle   {
  position: absolute;
  width: 139px;
  height: 42px;
  left: 0px;
  top: 20px;

  font-style: normal;
  font-weight: bold;
  font-size: 36px;
  line-height: 42px;

  color: #777575;
}

#editTitle      {
  position: absolute;
  width: 139px;
  height: 42px;
  left: 0px;
  top: 20px;

  font-style: normal;
  font-weight: bold;
  font-size: 36px;
  line-height: 42px;

  color: #777575;
}

.searchSubtitle {
  position: absolute;
  width: 353px;
  height: 56px;
  left: 0px;
  top: 100px;

  font-style: normal;
  font-weight: 500;
  font-size: 24px;
  line-height: 28px;

  color: #FFFFFF;
}

#entrySubtitle  {
  position: absolute;
  width: 353px;
  height: 56px;
  left: 0px;
  top: 100px;

  font-style: normal;
  font-weight: 500;
  font-size: 24px;
  line-height: 28px;

  color: #777575;
}

#editSubtitle   {
  position: absolute;
  width: 353px;
  height: 56px;
  left: 0px;
  top: 100px;

  font-style: normal;
  font-weight: 500;
  font-size: 24px;
  line-height: 28px;

  color: #777575;
}

.searchBtn    {
  position: absolute;
  width: 124px;
  height: 52px;
  left: 210px;
  top: 110px;

  background: #FFFFFF;
  border-radius: 2px;
}

#entryBtn     {
  position: absolute;
  width: 124px;
  height: 52px;
  left: 200px;
  top: 200px;

  background: #64D8CB;
  border-radius: 2px;
}

#editBtn      {
  position: absolute;
  width: 124px;
  height: 52px;
  left: 200px;
  top: 200px;

  background: #64D8CB;
  border-radius: 2px;
}
</style>
