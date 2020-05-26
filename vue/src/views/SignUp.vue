<template>
  <v-app id="signUp">
    <div class="logo">
      <img src="../assets/chartLogo.svg">
    </div>
    <!-- pxのpはpadding, mxのmはmargin, xyは横縦, 数字は大きさに対応 -->
    <v-card width="500px" class="spacing-playground px-10 py-10 mx-auto my-10">
      <v-card-title>
        <div class="mx-auto">
          新規登録
        </div>
      </v-card-title>
      <v-card-text>
        <v-form
          ref="form"
        >
          <v-text-field v-model="username" prepend-icon="mdi-account-circle" label="アカウント名" :rules="[required]" color="#3949AB" />
          <v-text-field v-model="email" prepend-icon="mdi-gmail" label="メールアドレス" :rules="[required, emailRules]" color="#3949AB" />
          <!-- mdi-eye-offの部分はブラッシュアップにまわす -->
          <v-text-field v-model="password" :type="show ? 'text' : 'password'" :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'" prepend-icon="mdi-lock" label="パスワード" :rules="[required, max_length]" color="#3949AB" @click:append="show = !show" />
          <v-card-actions>
            <v-col cols="12">
              <v-btn large color="#FF625C" class="my-2 white--text" block @click="signup()">
                新規登録をする
              </v-btn>
              <v-btn class="mt-5" text large color="#3949AB" block to="/">
                ログイン画面に戻る
              </v-btn>
            </v-col>
          </v-card-actions>
        </v-form>
      </v-card-text>
    </v-card>
  </v-app>
</template>

<script>
import axios from 'axios'

export default {
  data: () => ({
    username: '',
    email: '',
    // メアドのバリデーション規則
    emailRules: value => {
      const pattern = /^(([^<>()[\]\\.,;:\s@]+(\.[^<>()[\]\\.,;:\s@]+)*)|(.+))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
      return pattern.test(value) || 'メールアドレスの形式が正しくありません'
    },
    password: '',
    max_length: value => value.length >= 8 || '8文字以上で入力してください',
    // 基本バリデーション
    required: value => !!value || '必ず入力してください',
    show: false
  }),
  methods: {
    signup () {
      if (this.$refs.form.validate()) {
        const url = '/api/auth/signup'
        axios.post(url, {
          username: this.username,
          email: this.email,
          password: this.password
        })
        this.$router.push('/')
      }
    }
  }
}
</script>
<style>
#signUp{
  background-color: #f4f2ec;
}
.logo{
  text-align: center;
  margin: 100px 10px 10px 10px;
}
</style>
