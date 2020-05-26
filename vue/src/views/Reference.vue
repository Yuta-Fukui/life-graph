<template>
  <v-app id="reference">
    <div id="ref" />
    <Header />
    <v-container>
      <v-row>
        <v-col>
          <v-btn id="returnBtn" class="mt-10" to="/life-graph/lists" outlined large color="#495183">
            戻る
          </v-btn>
        </v-col>
      </v-row>
      <v-row justify="center" class="mb-10">
        <v-col class="mr-10" cols="12" sm="12" md="8" lg="6">
          <v-card class="pa-10">
            <ChartRef />
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </v-app>
</template>

<script>
import ChartRef from '../chart/ChartRef'
import Header from '../components/Header.vue'

export default {
  name: 'Reference',
  //     extends: Radar,
  components: {
    ChartRef,
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
#reference {
  background-color: #f4f2ec;
}
#ref{
  padding:30px
}
</style>
