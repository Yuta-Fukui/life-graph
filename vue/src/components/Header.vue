<template>
  <div id="header">
    <v-app-bar
      color="#495183"
      dark
      flat
    >
      <v-toolbar-title>
        <img class="mt-1 ml-2 mr-2" src="../assets/headerLogo.svg">
      </v-toolbar-title>
      <v-toolbar-items class="ml-4">
        <v-btn
          text
          to="/top"
        >
          トップ
        </v-btn>
        <v-btn
          text
          to="/life-graph/lists"
        >
          検索
        </v-btn>
      </v-toolbar-items>
      <v-spacer />
      <v-toolbar-items>
        <ul>
          <li>ユーザー名</li>
          <li
            class="ma-3"
          >
            {{ username }}
          </li>
          <li>
            /
          </li>
          <li
            class="ma-3"
          >
            権限名
          </li>
          <li>{{ authority }}</li>
        </ul>
        <v-divider
          class="mx-4"
          inset
          vertical
        />
        <v-btn
          text
          @click="logout()"
        >
          ログアウト
        </v-btn>
      </v-toolbar-items>
    </v-app-bar>
  </div>
</template>

<script>
export default {
  data () {
    return {
      username: '',
      authority: ''
    }
  },
  // ブラウザに表示されル時ににマウントされる
  async mounted () {
    // userIdを取得し、dispatchでaccountでactionを起こす
    const userId = this.$store.state.auth.userId
    await this.$store.dispatch('accountAction', userId)
    this.setAccount()
  },
  methods: {
    setAccount () {
      const accountInfo = this.$store.state.account.accountInfo
      this.username = accountInfo.username
      const authority = accountInfo.name
      if (authority === 'ROLE_USER') {
        this.authority = '一般ユーザー'
      } else if (authority === 'ROLE_ADMIN') {
        this.authority = '管理者'
      } else {
        this.authority = 'オーナー'
      }
    },
    logout () {
      this.$store.commit('delete')
      this.$store.commit('resetContents')
      this.$router.push('/')
    }
  }

}
</script>
<style scoped>
#header{
  position: fixed;
  width: 100%;
  z-index: 2;
}

ul {
  align-items: center;
  display: flex;
  list-style: none;
}
</style>
