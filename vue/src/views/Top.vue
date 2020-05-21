<template>
  <v-app id="top">
    <v-container>
      <!-- <p v-if="login"> -->
      <v-row style="height: 450px;"
             justify="center" align-content="center"
      >
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
              <router-link to="/life-graph/lists">
                <v-btn class="#777575--text" color="#FFFFFF">
                  検索する
                </v-btn>
              </router-link>
            </v-card-actions>
          </v-card>
        </v-col>
        <v-col cols="12" sm="6" md="4">
          <v-card
            id="topEdit"
            class="mx-auto"
            max-width="344"
            large color="#FFFFFF"
          >
            <v-list-item three-line>
              <v-list-item-content>
                <v-list-item-title id="editTitle" class="#777575--text">
                  編集
                </v-list-item-title>
                <v-list-item-subtitle id="editSubtitle" class="#777575--text">
                  人生グラフの項目の追加・訂正を行えます。
                </v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
            <v-card-actions>
              <router-link to="/new">
                <v-btn class="white--text" color="#26A69A">
                  編集する
                </v-btn>
              </router-link>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
      <v-row
        justify="center" align-content="center"
      >
        <v-col>
          <div id="topChart" style="width:600px;height:auto;">
            <Chart />
          </div>
        </v-col>
      </v-row>
      <!-- </p> -->
      <!-- <p v-else> -->
      <v-row style="height: 450px;"
             justify="center" align-content="center"
      >
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
              <router-link to="/life-graph/lists">
                <v-btn class="#777575--text" color="#FFFFFF">
                  検索する
                </v-btn>
              </router-link>
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
                  登録
                </v-list-item-title>
                <v-list-item-subtitle id="entrySubtitle" class="#777575--text">
                  人生グラフを作成できます。
                </v-list-item-subtitle>
              </v-list-item-content>
            </v-list-item>
            <v-card-actions>
              <router-link to="/new">
                <v-btn id="entryBtn" class="white--text" color="#26A69A">
                  登録する
                </v-btn>
              </router-link>
            </v-card-actions>
          </v-card>
        </v-col>
      </v-row>
      <!-- </p> -->
    </v-container>
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
/* // #topChart {
//   position:absolute;
//   top:400px;
//   right:200px;
//   width: 300px;
//   height: 300px;
//   margin: 0 auto;
// }

// #topSearchBef   {
//   position: absolute;
//   width: 404px;
//   height: 264px;
//   left: 263px;
//   top: 231px;

//   background: #26A69A;
//   box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
//   border-radius: 2px;
// }

// #topSearchAft   {
//   position: absolute;
//   width: 404px;
//   height: 264px;
//   left: 263px;
//   top: 231px;

//   background: #26A69A;
//   box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
//   border-radius: 2px;
// }

// #topEntry   {
//   position: absolute;
//   width: 404px;
//   height: 264px;
//   left: 769px;
//   top: 231px;

//   background: #FFFFFF;
//   border: 2px solid #26A69A;
//   box-sizing: border-box;
//   box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
//   border-radius: 2px;
// }

// #topEdit    {
//   position: absolute;
//   width: 404px;
//   height: 264px;
//   left: 769px;
//   top: 231px;

//   background: #FFFFFF;
//   border: 2px solid #26A69A;
//   box-sizing: border-box;
//   box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
//   border-radius: 2px;
// }

// .searchTitle  {
//   position: absolute;
//   width: 139px;
//   height: 42px;
//   left: 0px;
//   top: 20px;

//   font-style: normal;
//   font-weight: bold;
//   font-size: 36px;
//   line-height: 42px;

//   color: #FFFFFF;
// }

// #entryTitle   {
//   position: absolute;
//   width: 139px;
//   height: 42px;
//   left: 0px;
//   top: 20px;

//   font-style: normal;
//   font-weight: bold;
//   font-size: 36px;
//   line-height: 42px;

//   color: #777575;
// }

// #editTitle      {
//   position: absolute;
//   width: 139px;
//   height: 42px;
//   left: 0px;
//   top: 20px;

//   font-style: normal;
//   font-weight: bold;
//   font-size: 36px;
//   line-height: 42px;

//   color: #777575;
// }

// .searchSubtitle {
//   position: absolute;
//   width: 353px;
//   height: 56px;
//   left: 0px;
//   top: 100px;

//   font-style: normal;
//   font-weight: 500;
//   font-size: 24px;
//   line-height: 28px;

//   color: #FFFFFF;
// }

// #entrySubtitle  {
//   position: absolute;
//   width: 353px;
//   height: 56px;
//   left: 0px;
//   top: 100px;

//   font-style: normal;
//   font-weight: 500;
//   font-size: 24px;
//   line-height: 28px;

//   color: #777575;
// }

// #editSubtitle   {
//   position: absolute;
//   width: 353px;
//   height: 56px;
//   left: 0px;
//   top: 100px;

//   font-style: normal;
//   font-weight: 500;
//   font-size: 24px;
//   line-height: 28px;

//   color: #777575;
// }

// .searchBtn    {
//   position: absolute;
//   width: 124px;
//   height: 52px;
//   left: 210px;
//   top: 110px;

//   background: #FFFFFF;
//   border-radius: 2px;
// }

// #entryBtn     {
//   position: absolute;
//   width: 124px;
//   height: 52px;
//   left: 200px;
//   top: 200px;

//   background: #64D8CB;
//   border-radius: 2px;
// }

// #editBtn      {
//   position: absolute;
//   width: 124px;
//   height: 52px;
//   left: 200px;
//   top: 200px;

//   background: #64D8CB;
//   border-radius: 2px;
// } */
</style>
