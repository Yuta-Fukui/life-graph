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
        <v-form>
          <v-text-field type="mail" prepend-icon="mdi-gmail" label="メールアドレス" />
          <!-- mdi-eye-offの部分は時間がなければなくします -->
          <v-text-field type="password" prepend-icon="mdi-lock" append-icon="mdi-eye-off" label="パスワード" />
          <v-card-actions>
            <!-- ボタンのカラー変更は調査中 -->
            <!-- <v-btn color="teal">新規登録</v-btn> -->
            <!-- <v-btn outline color="#26A69A">新規登録</v-btn> -->
            <v-btn outlined large color="#26A69A" to="/Signup">
              新規登録
            </v-btn>
            <v-spacer />
            <v-btn large color="#26A69A" class="log-btn" to="/Top">
            <v-btn outlined large color="#26A69A" to="/signup">
              新規登録
            </v-btn>
            <v-spacer />
            <v-btn large color="#26A69A" class="log-btn" to="/top">
              ログイン
            </v-btn>
            <!-- <v-btn  color="pink">ログイン</v-btn> -->
          </v-card-actions>
        </v-form>
      </v-card-text>
    </v-card>
  </div>
</template>

<style scoped>
</style>
<script>
export default {
  layout: 'blank', // layouts/blank.vueを使用
  middleware: ['auth'],
  data () {
    return {
      valid: true,
      email: '',
      password: '',
      error: null
    }
  },
  methods: {
    async login () {
      this.error = null
      if (this.$refs.form.validate()) {
        return this.$auth
          .loginWith('local', {
            data: {
              email: this.email,
              password: this.password
            }
          })
          .catch(e => {
            this.error = 'ログインに失敗しました。IDかパスワードが間違っている可能性があります。'
          })
      }
    }
  },
  head () {
    return {
      title: 'ログイン'
    }
  }
}
// sriptはブラッシュアップに回します
// export default {
//   layout: 'blank', // layouts/blank.vueを使用
//   middleware: ['auth'],
//   data () {
//     return {
//       valid: true,
//       email: '',
//       password: '',
//       error: null
//     }
//   },
//   methods: {

//     async login () {
//       this.error = null

//       if (this.$refs.form.validate()) {
//         return this.$auth
//           .loginWith('local', {
//             data: {
//               email: this.email,
//               password: this.password
//             }
//           })
//           .catch(e => {
//             this.error = 'ログインに失敗しました。IDかパスワードが間違っている可能性があります。'
//           })
//       }
//     }
//   },
//   head () {
//     return {
//       title: 'ログイン'
//     }
//   }
// }
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
