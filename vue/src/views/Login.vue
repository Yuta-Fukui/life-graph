<template>
  <v-app id="login">
    <div class="logo">
      <img src="../assets/chartLogo.svg">
    </div>
    <!-- pxのpはpadding, mxのmはmargin, xyは横縦, 数字は大きさに対応 -->
    <v-card width="500px" class="spacing-playground px-10 py-10 mx-auto my-10">
      <v-card-title>
        <div class="mx-auto title">
          ログイン
        </div>
      </v-card-title>
      <v-card-text>
        <v-form
          ref="form"
        >
          <v-text-field v-model="email" type="email" prepend-icon="mdi-gmail" label="メールアドレス" :rules="[required, emailRules]" color="#3949AB" />
          <!-- mdi-eye-offの部分は時間がなければなくします -->
          <v-text-field v-model="password" :type="show ? 'text' : 'password'" :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'" prepend-icon="mdi-lock" label="パスワード" :rules="[required,max_length]" color="#3949AB" @click:append="show = !show" />
          <v-card-actions>
            <v-col cols="12">
              <v-btn large color="#FF625C" class="my-2 white--text" block @click="login()">
                ログインする
              </v-btn>
              <v-btn class="mt-5" text large color="#3949AB" block to="/signup">
                新規登録する
              </v-btn>
            </v-col>
          </v-card-actions>
        </v-form>
        <v-layout justify-center>
          <p>
            アカウントをお持ちでない方はこちら
          </p>
        </v-layout>
      </v-card-text>
    </v-card>
  </v-app>
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
    max_length: value => value.length >= 8 || '8文字以上で入力してください',
    required: value => !!value || '必ず入力してください',
    show: false
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
#login {
  background-color: #f4f2ec;
}
.logo {
  text-align: center;
  margin: 100px 10px 10px 10px;
}

/* ログインボタンの文字色 */
/* .theme--light.v-btn:not(.v-btn--flat):not(.v-btn--text):not(.v-btn--outlined){
  color:white;
} */

</style>
