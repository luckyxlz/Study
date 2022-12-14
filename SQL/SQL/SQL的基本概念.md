## SQL的基本概念

- `数据库`：“数据库是一个以某种有组织的方式存储的数据集合”

- `数据库软件` ："数据库软件应称为数据库管理系统（即DBMS）”

- `列（column）`："表中的一个字段。所有表都是由一个或多个列组成的。”

  - `数据类型` ：所允许的数据的类型。每个表列都有相应的数据类型，它限制（或允许）该列中存储的数据。”

- `行`：（row）表中的一个记录。”

- `主键`：（primary key）一列（或一组列），其值能够唯一标识表中每一行。”

  - > - 提示：应该总是定义主键
    >
    >   虽然并不总是需要主键，但多数数据库设计者都会保证他们创建的每个表具有一个主键，以便于以后的数据操作和管理。”任意两行都不具有相同的主键值；
    >
    > - 每一行都必须具有一个主键值（主键列不允许NULL值）；
    >
    > - 主键列中的值不允许修改或更新；
    >
    > - 主键值不能重用（如果某行从表中删除，它的主键不能赋给以后的新行）。”

- `SQL`：结构化查询语言，用来与数据库沟通的语言

