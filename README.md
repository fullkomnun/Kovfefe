[![Build Status](https://travis-ci.org/RubyLichtenstein/Kovfefe.svg?branch=master)](https://travis-ci.org/RubyLichtenstein/Kovfefe)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/3b5d99686df447eea2d9c73d51085966)](https://www.codacy.com/app/reuven.lichtenstein/Kovfefe?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=RubyLichtenstein/Kovfefe&amp;utm_campaign=Badge_Grade)


#### Kovfefe

### Kotlin library for genrating data types.

### 

```kotlin
      data class BasicType(
            val string: String,
            val int: Int,
            val long: Long,
            val float: Float,
            val boolean: Boolean,
            val double: Double,
            val char: Char,
            val byte: Byte
        )
        
        val foo = generate<BasicType>()
               
```

