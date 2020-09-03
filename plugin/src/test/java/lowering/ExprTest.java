package lowering;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static util.CompileAssert.assertCompiled;

public class ExprTest {

    @Test
    void literal() throws IOException {
        assertCompiled(
            """
                package js;
                public class Test {
                  void baz() {
                    boolean x0 = true;
                    boolean x1 = false;
                    int x2 = 42;
                    long x3 = 42;
                    float x4 = 42.0f;
                    double x5 = 42.0d;
                    Character x6 = 'A';
                    String x7 = "hello";
                    Object x8 = null;
                  }
                }""",
            """
                class js$Test {
                  baz() {
                    let x0 = true
                    let x1 = false
                    let x2 = 42
                    let x3 = 42
                    let x4 = 42.0
                    let x5 = 42.0
                    let x6 = 'A'
                    let x7 = 'hello'
                    let x8 = null
                  }
                }""");
    }


    @Test void assignment() throws IOException {
        assertCompiled(
            """
                package js;
                public class Test {
                  void baz() {
                    int x;
                    x = 42;
                  }
                }""",
            """
                class js$Test {
                  baz() {
                    let x = null
                    x = 42
                  }
                }""");
    }

    @Test
    void varId() throws IOException {
        assertCompiled(
            """
                package js;
                public class Test {
                  void baz() {
                    boolean x = true;
                    boolean y = x;
                  }
                }""",
            """
                class js$Test {
                  baz() {
                    let x = true
                    let y = x
                  }
                }""");
    }

    @Test void ternary() throws IOException {
        assertCompiled(
            """
                package js;
                public class Test {
                  void boolToInt() {
                    int x = true ? 1 : 0;
                  }
                }""",
            """
                class js$Test {
                  boolToInt() {
                    let x = true ? 1 : 0
                  }
                }""");
    }

    @Test void unaryOp() throws IOException {
        assertCompiled(
            """
                package js;
                public class Test {
                  void baz() {
                    int x = 0;
                    int x1 = x++;
                    int x2 = x--;
                    int x3 = ++x;
                    int x4 = --x;
                    int x5 = +1;
                    int x6 = -1;
                    int x7 = ~1;
                    boolean y = true;
                    boolean y1 = !y;
                  }
                }""",
            """
                class js$Test {
                  baz() {
                    let x = 0
                    let x1 = x++
                    let x2 = x--
                    let x3 = ++x
                    let x4 = --x
                    let x5 = +1
                    let x6 = -1
                    let x7 = ~1
                    let y = true
                    let y1 = !y
                  }
                }""");
    }

    @Test void binaryOp() throws IOException {
        assertCompiled(
            """
                package js;
                public class Test {
                  void baz() {
                    int x0 = 1 * 1;
                    int x1 = 1 / 1;
                    int x2 = 1 % 1;
                    int x3 = 1 + 1;
                    int x4 = 1 - 1;
                    int y0 = 1 << 1;
                    int y1 = 1 >> 1;
                    int y2 = 1 >>> 1;
                    boolean z0 = 1 < 1;
                    boolean z1 = 1 > 1;
                    boolean z2 = 1 <= 1;
                    boolean z3 = 1 >= 1;
                    boolean z4 = 1 == 1;
                    boolean z5 = 1 != 1;
                    int k0 = 1 & 1;
                    int k1 = 1 ^ 1;
                    int k2 = 1 | 1;
                    boolean b0 = true && false;
                    boolean b1 = true || false;
                  }
                }""",
            """
                class js$Test {
                  baz() {
                    let x0 = 1 * 1
                    let x1 = 1 / 1
                    let x2 = 1 % 1
                    let x3 = 1 + 1
                    let x4 = 1 - 1
                    let y0 = 1 << 1
                    let y1 = 1 >> 1
                    let y2 = 1 >>> 1
                    let z0 = 1 < 1
                    let z1 = 1 > 1
                    let z2 = 1 <= 1
                    let z3 = 1 >= 1
                    let z4 = 1 == 1
                    let z5 = 1 != 1
                    let k0 = 1 & 1
                    let k1 = 1 ^ 1
                    let k2 = 1 | 1
                    let b0 = true && false
                    let b1 = true || false
                  }
                }""");
    }

    @Test void compoundAssignment() throws IOException {
        assertCompiled(
            """
                package js;
                public class Test {
                  void baz() {
                    int x = 0;
                    x *= 1;
                    x /= 1;
                    x %= 1;
                    x += 1;
                    x -= 1;
                    x <<= 1;
                    x >>= 1;
                    x >>>= 1;
                    x &= 1;
                    x ^= 1;
                    x |= 1;
                  }
                }""",
            """
                class js$Test {
                  baz() {
                    let x = 0
                    x *= 1
                    x /= 1
                    x %= 1
                    x += 1
                    x -= 1
                    x <<= 1
                    x >>= 1
                    x >>>= 1
                    x &= 1
                    x ^= 1
                    x |= 1
                  }
                }""");
    }
}
