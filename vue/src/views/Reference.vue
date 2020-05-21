<template>
  <v-app id="reference">
    <Header />
    <v-container>
      <v-row>
        <v-col>
          <v-btn id="returnBtn" to="/search" outlined large color="#26A69A">
            <v-icon />戻る
          </v-btn>
        </v-col>
      </v-row>
      <v-row>
        <v-col>
          <div id="refChart" style="width:750px;height:auto" justify="center">
            <Chart />
          </div>
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
import Chart from '../chart/Chart'
import Header from '../components/Header.vue'

export default {
  name: 'Reference',
  //     extends: Radar,
  components: {
    Chart,
    Header
  },
  //   data () {
  //     return {
  //       data: {
  //         labels: [],
  //         datasets: [
  //           {
  //             data: [],
  //           },
  //         ]
  //       },
  //       options: {
  //         responsive: true,
  //         scale: {
  //           ticks: {
  //             maxTicksLimit: 100,
  //             beginAtZero: true,
  //             max:100,
  //             min:-100,
  //           }
  //         },
  //         legend: {
  //           display:false,
  //         }
  //       }
  //     }
  //   },
  //   mounted () {
  //     this.get();
  //     this.renderChart(this.data, this.options);
  //    // this.$store.dispatch('updateSkillCategories')
  //   },
  //   methods:{
  //     getSkills(){
  //       const backSkillInfo = this.$store.getters.get('back-end')
  //       console.log(backSkillInfo)
  //       backSkillInfo.skills.forEach((skill) => {
  //         this.data.labels.push(skill.name),
  //         this.data.datasets[0].data.push(skill.score)
  //       })
  //     }
  //   }
  // }

  data: () => ({
    //
  })
}
</script>

<style>

</style>
