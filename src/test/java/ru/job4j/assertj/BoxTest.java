package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test

    void isThisCube() {
        Box box = new Box(8, 12);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void isThisTetrahedron() {
        Box box = new Box(4, 6);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron");
    }

    @Test
    void isSphereAreaCalcCorrect() {
        Box box = new Box(0, 10);
        double area = box.getArea();
        assertThat(area).isNotZero().isNotNegative().isCloseTo(1256.64d, withPrecision(0.005d));
    }

    @Test
    void isCubeAreaCalcCorrect() {
        Box box = new Box(8, 10);
        double area = box.getArea();
        assertThat(area).isNotZero().isNotNegative().isCloseTo(600.00d, withPrecision(0.005d));
    }

    @Test
    void isTetrahedronAreaCalcCorrect() {
        Box box = new Box(4, 10);
        double area = box.getArea();
        assertThat(area).isNotZero().isNotNegative().isCloseTo(173.21d, withPrecision(0.005d));
    }

    @Test
    void isExistWorksCorrect() {
        Box box1 = new Box(0, 10);
        Box box2 = new Box(4, 10);
        Box box3 = new Box(8, 10);
        Box box4 = new Box(-1, 10);
        Box box5 = new Box(-5, 10);
        boolean exist1 = box1.isExist();
        boolean exist2 = box2.isExist();
        boolean exist3 = box3.isExist();
        boolean exist4 = box4.isExist();
        boolean exist5 = box5.isExist();
        assertThat(exist1).isTrue();
        assertThat(exist2).isTrue();
        assertThat(exist3).isTrue();
        assertThat(exist4).isFalse();
        assertThat(exist5).isFalse();
    }

    @Test
    void isGetNumberOfVerticesWorksCorrect() {
        Box box1 = new Box(0, 10);
        Box box2 = new Box(4, 10);
        Box box3 = new Box(-4, 10);
        int vertex1 = box1.getNumberOfVertices();
        int vertex2 = box2.getNumberOfVertices();
        int vertex3 = box3.getNumberOfVertices();
        assertThat(vertex1).isZero();
        assertThat(vertex2).isNotZero().isPositive().isEqualTo(4);
        assertThat(vertex3).isNotZero().isNegative().isEqualTo(-1);
    }
}