<template>
  <div id="reference">
    <v-btn id="returnBtn">
      <v-icon />戻る
    </v-btn>
    <div id="refChart">
      <Chart />
    </div>
  </div>
</template>

<script>
import Chart from '../chart/Chart'
export default {
  name: 'Reference',
  components: {
    Chart
  },

  data: () => ({
    //
  })
}

</script>

<style>
/* #returnBtn    {
  background: #FFFFFF;
  font-family: Roboto;
  font-style: normal;
  font-weight: 500;
  font-size: 18px;
  line-height: 21px;
  /* identical to box height */
  /* color: #26A69A;}

#refChart     {
  width: 300px;
  height: 300px;
  margin: 0 auto;} */
</style>
