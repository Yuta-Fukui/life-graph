<template>
  <v-app id="inspire">
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <!-- <div class="overline mb-4">OVERLINE</div> -->
          <v-list-item-title class="serch-title">
            検索
          </v-list-item-title>
          <v-list-item-subtitle>こちらの検索ボタンから人生グラフを検索できます</v-list-item-subtitle>
        </v-list-item-content>

        <v-list-item-avatar
          tile
          size="80"
          color="grey"
        />
      </v-list-item>
      <v-card-actions>
        <v-btn text>
          検索する
        </v-btn>
      </v-card-actions>
    </v-card>
    <v-card
      class="mx-auto"
      max-width="344"
      outlined
    >
      <v-list-item three-line>
        <v-list-item-content>
          <!-- <div class="overline mb-4">OVERLINE</div> -->
          <v-list-item-title class="entry-title">
            登録
          </v-list-item-title>
          <v-list-item-subtitle>こちらのボタンから人生グラフを登録できます</v-list-item-subtitle>
        </v-list-item-content>

        <v-list-item-avatar
          tile
          size="80"
          color="grey"
        />
      </v-list-item>
      <v-card-actions>
        <v-btn text>
          登録する
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-app>
  <!-- <div class="top">
    <button class="top-serch" onclick="src=/..'">
      検索画面
    </button>
    <button class="top-entry" onclick="src=/..'">
      登録画面
    </button>
  </div> -->
</template>

<script>

// @ is an alias to /src
// import HelloWorld from '@/components/HelloWorld.vue'

// export default {
//   name: 'Home',
//   components: {
//     HelloWorld
//   },

//   created () {
//     this.$store.dispatch('fetchLogin')
//   }
// }
</script>
