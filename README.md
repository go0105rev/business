<<<<<<< HEAD

コンパイル<br>
javac -encoding utf-8 C:\home\codeLearn\evaculation\A9999999999999999997.java<br>
実行<br>
java -cp /home/codeLearn/evaculation/ A9999999999999999997<br>

elearn_batch
　∟ java21
  ∟ terasoluna
　∟ tomcat10.1.36 (参考)
　∟ postgresql 15 (参考：https://qiita.com/koinunopochi/items/3993d0ad10d21d549e46)

postgresのアクセス権限試し修正（pg_hba.conf）
////////////////////////////////////////////////////
# TYPE  DATABASE        USER            ADDRESS                 METHOD
host    elearning             elearn_user             0.0.0.0/0            md5
host    all             all             ::1/128                 md5
# "local" is for Unix domain socket connections only
local   all             all                                     md5
# IPv4 local connections:
#host    all             all             127.0.0.1/32            ident
# IPv6 local connections:
#host    all             all             ::1/128                 ident
# Allow replication connections from localhost, by a user with the
# replication privilege.
local   replication     all                                     peer
host    replication     all             0.0.0.0/0               md5
host    replication     all             ::1/128                 ident
////////////////////////////////////////////////////

>>>>>>> upstream/main
