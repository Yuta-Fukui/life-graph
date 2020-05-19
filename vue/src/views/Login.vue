<template>
  <div id="login">
    <div class="logo">
      <img src="../assets/lifeChartLogo.svg">
    </div>
    <!-- pxのpはpadding, mxのmはmargin, xyは横縦, 数字は大きさに対応 -->
    <v-card width="500px" class="spacing-playground px-10 py-10 mx-auto my-10">
      <v-card-title>
        <h1 class="mx-auto">
          ログイン
        </h1>
      </v-card-title>
      <v-card-text>
        <v-form
          ref="form"
        >
          <v-text-field v-model="email" type="mail" prepend-icon="mdi-gmail" label="メールアドレス" :rules="[required, emailRules]" />
          <!-- mdi-eye-offの部分は時間がなければなくします -->
          <v-text-field v-model="password" type="password" prepend-icon="mdi-lock" append-icon="mdi-eye-off" label="パスワード" :rules="[required]" />
          <v-card-actions>
            <v-btn outlined large color="#26A69A" to="/signup">
              新規登録
            </v-btn>
            <v-spacer />
            <v-btn large color="#26A69A" class="log-btn" @click="login()">
              ログイン
            </v-btn>
          </v-card-actions>
        </v-form>
      </v-card-text>
    </v-card>
  </div>
</template>
<script>
// sriptはブラッシュアップに回します
export default {
  layout: 'blank', // layouts/blank.vueを使用
  middleware: ['auth'],
  data: () => ({
    email: '',
    emailRules: value => {
      const pattern = /^(([^<>()[\]\\.,;:\s@]+(\.[^<>()[\]\\.,;:\s@]+)*)|(.+))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      return pattern.test(value) || 'メールアドレスの形式が正しくありません'
    },
    password: '',
    required: value => !!value || '必ず入力してください'
  }),
  // token関数でtokenの値を取得する
  computed: {
    token () {
      return this.$store.state.auth.token
    }
  },
  // token関数の監視を行う
  watch: {
    token (newToken) {
      this.$router.push('/top')
    }
  },
  methods: {
    login () {
      if (this.$refs.form.validate()) {
        this.$store.dispatch('fetchLogin', { email: this.email, password: this.password })
        this.$router.push('/top')
      }
    }
    // async login () {
    //   this.error = null
    //   if (this.$refs.form.validate()) {
    //     return this.$auth
    //       .loginWith('local', {
    //         data: {
    //           email: this.email,
    //           password: this.password
    //         }
    //       })
    //       .catch(e => {
    //         this.error = 'ログインに失敗しました。IDかパスワードが間違っている可能性があります。'
    //       })
    //   }
    // }
  }
  // head () {
  //   return {
  //     title: 'ログイン'
  //   }
  // }
}
</script>

<style>
.logo{
  text-align: center;
  margin: 60px;
}
/* ログインボタンの文字色 */
.theme--light.v-btn:not(.v-btn--flat):not(.v-btn--text):not(.v-btn--outlined){
  color:white;
}
</style>
