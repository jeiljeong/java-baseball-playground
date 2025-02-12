package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void split() {
        String[] actual = "1,2".split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void splitExactly() {
        String[] actual = "1".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    void removeParenthesis() {
        // given
        String given = "(1,2)";
        // when
        String actual = given.substring(1, 4);
        // then
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("OutOfBoundException")
    void outOfBoundException() {
        // given
        String given = "abc";
        // when
        assertThatThrownBy(() -> {
            int i = 0;
            while (true) {
                given.charAt(i++);
            }
        }).isInstanceOf(StringIndexOutOfBoundsException.class);
        // then
    }
}