public class RightTriangle2 {
    private double a; // Первый катет
    private double b; // Второй катет

    public RightTriangle2(double a, double b) {
        this.a = a;
        this.b = b;
    }


    // Гипотенуза
    public double getHypotenuse() {
        return Math.sqrt(a * a + b * b);
    }

    // Градусная мера углов
    public double getDegreeA() {
        return Math.toDegrees(Math.atan(a / b));
    }

    public double getDegreeB() {
        return Math.toDegrees(Math.atan(b / a));
    }

    // Синусы
    public double getSinA() {
        return a / getHypotenuse();
    }

    public double getSinB() {
        return b / getHypotenuse();
    }

    // Косинусы
    public double getCosA() {
        return b / getHypotenuse();
    }

    public double getCosB() {
        return a / getHypotenuse();
    }

    // Тангенс углов
    public double getTanA() {
        return a / b;
    }

    public double getTanB() {
        return b / a;
    }

    // Котангенс углов
    public double getCotA() {
        return b / a;
    }

    public double getCotB() {
        return a / b;
    }

    // Радиус вписанной окружности
    public double getVpisRadius() {
        return (a + b - getHypotenuse()) / 2;
    }

    // Радиус описанной окружности
    public double getOpisRadius() {
        return getHypotenuse() / 2;
    }

    // Проверка что это треугольник
    public static boolean isTriangle(double a, double b) {
        return a > 0 && b > 0;
    }

    // Вывод информации о треугольнике
    public void printInfo() {
        System.out.println("Катет a: " + a);
        System.out.println("Катет b: " + b);
        System.out.println("Гипотенуза: " + getHypotenuse());
        System.out.println("Градусная мера угла А: " + getDegreeA());
        System.out.println("Градусная мера угла B: " + getDegreeB());
        System.out.println("Синус угла A: " + getSinA());
        System.out.println("Синус угла B: " + getSinB());
        System.out.println("Косинус угла A: " + getCosA());
        System.out.println("Косинус угла B: " + getCosB());
        System.out.println("Тангенс угла A: " + getTanA());
        System.out.println("Тангенс угла B: " + getTanB());
        System.out.println("Котангенс угла A: " + getCotA());
        System.out.println("Котангенс угла B: " + getCotB());
        System.out.println("Радиус вписанной окружности: " + getVpisRadius());
        System.out.println("Радиус описанной окружности: " + getOpisRadius());
    }

}
