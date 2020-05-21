//package com.lifegraph.team20;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.lifegraph.team20.models.ChildReference;
//
////-----------------------------Controller定義----------------------------
//@RestController
//public class ReferenceController {
//
//// ロガー出力
//// public static final Logger logger =
//// LoggerFactory.getLogger(ReferenceController.class);
//// public String skillUpload(Locale locale, Model model) throws IOException {
//// logger.info("Welcome update! The client locale is {}.", locale);
//
////-----------------------------vueからのリクエストに対する処理----------------------------
//  @RequestMapping(value = "/reference", method = RequestMethod.GET) // vue側のgetメソッドと合わせる・・？
//  public List<ChildReference> responseReference() { // リクエストに応じたメソッド「responseReference」を定義。
//    // メソッド① ： child_graphsからデータを取得・整理
//    List<ChildReference> childRef = selectChildRef();
//
//    // id
//    // parent_id(Parentとリンク)
//    // age
//    // score
//    // comment
//
//    // メソッド② ： parent_graphsからデータを取得・整理
////    List<ParentReference> parentRef = selectParentRef();
//
//    // id(Childとリンク)
//    // user_id
//    // created_at
//    // updated_at
//
//    // メソッド③ ： ①②で取得したデータをvueのリクエストに合うように成形
////    List<Map<String, Object>> arrangeRef = uploadRef(childRef, parentRef);
//
//    // {{{ user_id : [id, user_id , created_at , updated_at] }
//    // : { parent_id : [id, parent_id, age, score, comment] }},・・・??
//
//    // メソッド①〜③までの処理結果をリターン
//    return childRef;
//  }
//
////-----------------------------①【SOLからデータを取得】----------------------------
//
//  // jdbcTemplateを使えるようにしている。MySQLと接続の設定を補助してくれる。ライブラリ参照。
//  @Autowired
//  private JdbcTemplate jdbcTemplate;
//
//  // (1)List型を返すメソッド「selectReference」を定義
//  // (2)String型の変数「sql」を定義。文字列「select * from child_graphs」を代入。
//  // (3)jdbcTemplateクラスの「queryメソッド」を起動。SQLに「select * from child_graphs」を実行させる。
//  // (4)mapRowメソッド。呪文。
//  // (5)Referenceクラス(②)を参照し、4つの引数からインスタンスを生成（箱に入れる？）し、mainメソッドへ返却。
//  // rs(ResultSet)クラスのgetStringメソッドでidなどを指定し、Referenceクラスに渡す。
//  // Referenceクラスから生成されたインスタンが返却される。
//
//  // 【ここで行ったこと】
//  // ・SQLのテーブルから全ての要素を取得（データはまだバラバラ）
//  // →[id,id,id,id,id,id,age,age,age,age,・・・comment,comment,]
//  // ・取得した値からReferenceクラスを参照してインスタンスを生成（データをレコードごとに整理）
//  // ・リクエストの処理へ結果を返却。
//
////-------------------①child--------------------
//  private List<ChildReference> selectChildRef() {
//    final String sql = "select * from child_graphs";
//    return jdbcTemplate.query(sql, new RowMapper<ChildReference>() {
//      public ChildReference mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return new ChildReference(rs.getInt("id"), rs.getInt("parent_id"), rs.getInt("age"), rs.getInt("score"),
//            rs.getString("comment"));
//      }
//    });
//  }
//
////-------------------①parent-------------------
////  private List<ParentReference> selectParentRef() {
////    final String sql = "select * from parent_graphs";
////    return jdbcTemplate.query(sql, new RowMapper<ParentReference>() {
////      public ParentReference mapRow(ResultSet rs, int rowNum) throws SQLException {
////        return new ParentReference(rs.getInt("id"), rs.getInt("user_id"), rs.getString("created_at"),
////            rs.getString("updated_at"));
////      }
////    });
////  }
//
//// ----------------------------③【①で生成したインスタンスのデータを整形】----------------------------
//  //
//  // (1)「uploadRefメソッド」を定義。①で取得したchildとparentの値が引数。
//  // (2)Map<String,Object>型のList変数「dataList」を定義。
//  // (3)Map<String, Object>型の変数「map」を定義。（未代入）
//  // (4)for(型 変数名 : List名){ 処理 } 。次の(5)〜(12)を繰り返す。
//  // (5)mapの初期化（再定義）
//  // (6)parent(=parentRef)からgetIメソッドで取得した値をHashMapに返却。
//  // put()メソッド：値をHashMapに返却。
//  // (7)同上
//  // (8)同上
//  // (9)同上
//  // (10)「streamAPI」の「filterメソッド」で取得する値の条件を設定。
//  // （「 親のId = 子のParent_id 」の場合のみ、以下の処理を行う。）
//  // (11)「streamAPI」の「collectメソッド」で・・（ここ微妙）
//  // (12)add()メソッドでmapの値をdataListへ。 →(5)
//  // (13)for文の処理が終了したら整形されたdatalistの値を返す。 →(2)
//
//  // 【ここで行ったこと】
//  // ・①でリクエスト処理に返却したデータをリクエストに合うように整形。
//  // ・リクエストの処理へ結果を返却。
//
////  private List<Map<String, Object>> uploadRef(List<ChildReference> childRef, List<ParentReference> parentRef) {
////    List<Map<String, Object>> dataList = new ArrayList<>();
////    Map<String, Object> map;
////    for (ParentReference parent : parentRef) {
////      map = new HashMap<>();
////      map.put("id", parent.getId());
////      map.put("user_id", parent.getUser_id());
////      map.put("created_at", parent.getCreated_at());
////      map.put("update_at", parent.getUpdated_at());
////      map.put("id", parentRef.stream().filter(x -> x.getId() == ChildReference.getParent_id())
////          .collect(Collectors.toList()));
////      dataList.add(map);
////    }
////    return dataList;
////  }
//}
////サーバーを停止・更新
////lsof -P -i:8080
////kill -9 2569