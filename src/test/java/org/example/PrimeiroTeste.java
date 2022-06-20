package org.example;




import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class PrimeiroTeste {

    Calculadora calculadora;

    @Before
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomar2Numeros() {

        //cenario
        int numero1 = 10, numero2 = 5;

        //execução
        int resultado = calculadora.somar(numero1, numero2);

        //verificaçôes
        Assert.assertEquals(15, resultado);
        //Assertions.assertThat(resultado).isBetween(14, 16);  //assertJ
        //Assertions.assertThat(resultado).isEqualTo(15);
    }

    @Test(expected = RuntimeException.class)
    public void naoDeveSomarNumerosNegativos() {
        //cenario
        int num1 = -10, num2 = 5;

        //execução
       calculadora.somar(num1, num2);

        //verificação

    }

    @Test
    public void deveSubtrair2Numeros() {
        //cenario
        int num1 = 5, num2 = 5;

        //execução
        int resultado = calculadora.subtrair(num1, num2);

        //verificação
        Assert.assertEquals(0, resultado);

    }

    @Test
    public void deveMultiplicar2Numeros() {
        //cenario
        int num1 = 5, num2 = 5;

        //execução
        int resultado = calculadora.multiplicar(num1, num2);

        //verificação
        Assert.assertEquals(25, resultado);

    }

    @Test
    public void deveDividir2Numeros() {
        //cenario
        int num1 = 30, num2 = 3;

        //execução
        int resultado = calculadora.divisao(num1, num2);

        //verificação
        Assert.assertEquals(10, resultado);

    }

    @Test(expected = ArithmeticException.class)
    public void naoDeveDividirPorZero() {
        //cenario
        int num1 = 30, num2 = 0;

        //execução
        calculadora.divisao(num1, num2);



    }
}

class Calculadora {

    int somar(int num, int num2) {
        if(num <0 || num2 < 0) {
             throw new RuntimeException ("Não e permitido somar numeros negativos");
        }
        return num + num2;
    }

    int subtrair(int num, int num2) {
        return num - num2;
    }

    int multiplicar(int num, int num2) {
        return num * num2;
    }

    int divisao(int num, int num2) {
        return num / num2;
    }
}
