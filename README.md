## 使用ライブラリ

### [Ktor](http://ktor.io/index.html)

JetBrains 製の Web フレームワーク。

coroutine を使用した非同期処理がベースになっている。

Web のみをカバーするシンプルなもの
(実際は Client もカバーするようであるが)。

Netty, Jetty 等を使用して動く(servlet としても動く)。

ORM 等は別途選定する必要がある。

### [Gson](https://github.com/google/gson)

JSON ライブラリ。

Jackson よりパフォーマンスが良さそう。

### [Guice](https://github.com/google/guice)

こちらはリフレクションベース。

[Dagger](https://github.com/google/dagger) はコード生成ベース。

どちらにするかは要検討。

### ORM

TODO

- [jOOQ](https://www.jooq.org/)  
  タイプセーフ SQL。 join したものを POJO にマッピングする等がすこし手間がかかりそう。
- [Exposed](https://github.com/JetBrains/Exposed)
  JetBrains が作っているが、まだ "Exposed is a prototype for a lightweight SQL library" って書いてあって怖い。
  JOOQ を kotlin に特化したような感じ?
- JPA + [Querydsl](http://www.querydsl.com/)  
  JPA の query builder が使いづらい部分を補える。
- [Spring Data JPA](https://projects.spring.io/spring-data-jpa/)
  Spring 導入するなら。
- [Doma](https://github.com/domaframework/doma)
  日本で比較的使われていそう。
  
### [SLF4J](https://www.slf4j.org/) + [Logback](https://logback.qos.ch/)

LSF4J は logging ライブラリの facade。  
裏で動く実際の logging ライブラリが Logback。

## 開発環境構築

Docker (つまり gradle) で動かす場合、 
Continuous Build (watch) がまだ incubating feature であり、
[いろいろと問題](https://docs.gradle.org/current/userguide/command_line_interface.html#_continuous_build)
があるので、 IDE で動かすほうが良さそう。

### Web サーバ を IDE 上で動かす

- [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
を入れる  
( 現在 [JDK 9](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html)
では [auto reload が動かない問題](https://github.com/ktorio/ktor/issues/71) 
がある。)
- IDEA でプロジェクトフォルダを `File > Open...` する
- IDEA が使用する SDK を JDK 8 にする。
- IDEA の `Run > Run` で `io.ktor.server.netty.DevelopmentEngine` を実行する
- open http://localhost:8080

## 日常の操作

### auto reload

http://ktor.io/servers/autoreload.html

.class ファイルが更新されると自動で load する。
対象となる .class は `out` という名前のフォルダにあるもの。 

- ソースを IDEA の `Build > Build Project` でコンパイルすると再読込される

### デバッグ

IDE から `Run > Debug` で `io.ktor.server.netty.DevelopmentEngine` を実行する

### テストの実行

### 依存関係の追加

[build.gradle](build.gradle) を編集する
