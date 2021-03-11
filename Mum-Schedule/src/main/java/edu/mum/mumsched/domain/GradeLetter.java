package edu.mum.mumsched.domain;

public enum GradeLetter {

    A_Plus(4.0),
    A(3.8),
    A_Minus(3.5),
    B_Plus(3.2),
    B(3.0),
    B_Minus(2.9),
    C_Plus(2.5),
    C(2.0),
    NC(0.0);

    private final double gradePoint;

    GradeLetter(double gradePoint) {
        this.gradePoint = gradePoint;
    }

    @Override
    public String toString() {
        final String name = name();

        if (name.contains("PLUS")) {
            return name.charAt(0) + "+";
        }
        else if (name.contains("MINUS")) {
            return name.charAt(0) + "-";
        }
        else {
            return name;
        }
    }

}
