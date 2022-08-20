        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>

注意这里的\<scope>表示依赖的在编译环境生效，在运行时失效，不加上会报错