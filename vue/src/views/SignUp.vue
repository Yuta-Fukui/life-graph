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
        <v-form>
          <v-text-field type="userName" prepend-icon="mdi-account-circle" label="アカウント名" />
          <v-text-field type="mail" prepend-icon="mdi-gmail" label="メールアドレス" />
          <!-- mdi-eye-offの部分はブラッシュアップにまわす -->
          <v-text-field type="password" prepend-icon="mdi-lock" append-icon="mdi-eye-off" label="パスワード" />
          <v-card-actions>
            <v-btn large color="#26A69A" class="signup-btn" to="/top">
              新規登録
            </v-btn>
          </v-card-actions>
        </v-form>
      </v-card-text>
    </v-card>
  </div>
</template>

<style scoped>
</style>

<script>
//
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
