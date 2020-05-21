<template>
  <div>
    <v-app-bar
      color="#26A69A"
      dark
    >
      <v-toolbar-title
        class="font-weight-bold"
      >
        Life Graph
      </v-toolbar-title>
      <v-toolbar-items>
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
          <li>User Name : </li>
          <li>{{ username }}</li>
          <li>権限名 : </li>
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
        this.authority = 'User'
      } else if (authority === 'ROLE_ADMIN') {
        this.authority = 'Administrator'
      } else {
        this.authority = 'Owner'
      }
    },
    logout () {
      this.$store.commit('delete')
      this.$router.push('/')
    }
  }

}
</script>
<style scoped>
ul {
  list-style: none;
  display: flex;
  align-items: center;
}
</style>
