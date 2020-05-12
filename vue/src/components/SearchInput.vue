<template>
  <div id="searchInput">
  <!--  <div class="searchBar" >
 input..text で一行入力用テキスト欄/placeholderで背景文字
       <input type="text" placeholder=検索したい氏名を入力してください>
    </div>
    <div class="searchButton">
      <input type="button" value="検索">
    </div>-->

    <form action="" method="post">
      <!--post:送受信するHTMLmethod-->
      <input type="text" name="searchBar"
        placeholder=検索したい氏名を入力してください size="30" />
        <!--input..text で一行入力用テキスト欄/placeholderで背景文字-->
      <input type="hidden" name="bid" value="%{BID}" />
      <!--type="hidden"非表示データを送信する-->
      <input type="submit" name="ACMS_POST_2GET" value="検索" />
      <!--type"submit"はフォームの送信ボタン作成-->
    </form>

    <img
      class="profilePicture"
      src="../assets/IMG_9975.png"
      alt="プロフィール写真"
    >
  </div>
</template>

<script>
</script>

<style scope>
/*#mainSection {
  width: 100%;
  height: 420px;
  display: block;
  background: linear-gradient(to bottom, #80e1f7, #06c1e6);
  padding-top: 40px;
}

.userName {
  color: #fff;
  font-family: 'Noto Sans JP', sans-serif;
  font-weight: bold;
  font-size: 30px;
  text-shadow: 2px 2px #808080;
  text-align: center;
  border-bottom: 1px solid white;
  width: 400px;
  margin: 0 auto;
  padding-bottom: 15px;
}*/
</style>
