<template>
  <div id="signUp">
    <div class="logo">
      <img src="../assets/lifeChartLogo.svg">
    </div>
    <!-- pxのpはpadding, mxのmはmargin, xyは横縦, 数字は大きさに対応 -->
    <v-card width="500px" class="spacing-playground px-10 py-10 mx-auto my-10">
      <v-card-title>
        <h1 class="mx-auto">
          新規登録
        </h1>
      </v-card-title>
      <v-card-text>
        <v-form
          ref="form"
        >
          <v-text-field v-model="username" prepend-icon="mdi-account-circle" label="アカウント名" :rules="[required]" color="teal" />
          <v-text-field v-model="email" prepend-icon="mdi-gmail" label="メールアドレス" :rules="[required, emailRules]" color="teal" />
          <!-- mdi-eye-offの部分はブラッシュアップにまわす -->
          <v-text-field v-model="password" :type="show ? 'text' : 'password'" :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'" prepend-icon="mdi-lock" label="パスワード" :rules="[required, max_length]" color="teal" @click:append="show = !show" />
          <v-card-actions>
            <v-btn large color="#26A69A" class="signup-btn" @click="signup()">
              新規登録をする
            </v-btn>
          </v-card-actions>
        </v-form>
      </v-card-text>
    </v-card>
  </div>
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
.logo{
  text-align: center;
  margin: 60px;
}
/* 新規登録ボタンの文字色と配置 */
.theme--light.v-btn:not(.v-btn--flat):not(.v-btn--text):not(.v-btn--outlined){
  color:white;
  margin-left:auto;
}
</style>
