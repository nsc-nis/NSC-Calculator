#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define add "add"
#define sub "sub"
#define mul "mul"
#define div "div"
#define mod "mod"
#define strc "strcmp"
#define stca "strcat"

//declare functions
void printMenu();
void getNumInput();
void getStringInput();
float addition(float num1, float num2);
float subtraction(float num1, float num2);
float multiplication(float num1, float num2);
float division(float num1, float num2);
int modulo(float num1, float num2);
float increment(float num);
float decrement(float num);

//declare variables
bool isRunning;
char input[50];
float input1;
float input2;
char strinput1[];
char strinput2[];

int main()
{
    //initialize variables
    isRunning = true;

    //Main program
    do
    {
        printMenu();
        gets(input);
        printf("* Your chose: %s\n", input);

        if (strcmp(input, add) == 0)
        {
            getNumInput("addition");
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result of %f + %f : %f\n", input1, input2, addition(input1, input2));
            printf("* |___________________________________________________________________________|\n");
        }
        if (strcmp(input, sub) == 0)
        {
            getNumInput("addition");
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result of %f + %f : %f\n", input1, input2, addition(input1, input2));
            printf("* |___________________________________________________________________________|\n");
        }


    }
    while (isRunning);



    return 0;
}

void printMenu()
{
    //Main Menu user interface
    printf("*  ___________________________________________________________________________ \n");
    printf("* |                   Welcome to NSC Calculator 1.5!                          |\n");
    printf("* |                         Development Edition                               |\n");
    printf("* |___________________________________________________________________________|\n");
    printf("* |Please choose one of the following operations by typing their command in ()|\n");
    printf("* | addition + (add)                                                          |\n");
    printf("* | subtraction - (sub)                                                       |\n");
    printf("* | multiplication * (mul)                                                    |\n");
    printf("* | division / (div)                                                          |\n");
    printf("* | modulo %% (mod)                                                           |\n");
    printf("* | String compare (strcmp)                                                   |\n");
    printf("* | String link (strcat)                                                      |\n");
    printf("* | increment ++ (inc)                                                        |\n");
    printf("* | decrement -- (dec)                                                        |\n");
    printf("* |___________________________________________________________________________|\n");
    printf("* | Type \"exit\" to quit the program                                         |\n");
    printf("* |___________________________________________________________________________|\n");
    printf("./CALCULATOR/");
}

void getNumInput(char operator[])
{
    printf("* Please type in the first number for the calculation:\n");
    printf("./CALCULATOR/%s", operator);
    scanf("%f", input1);

    printf("* Please type in the second number for the calculation:\n");
    printf("./CALCULATOR/%s", operator);
    scanf("%f", input2);

    printf("* Read numbers: %f %f", input1, input2);
}

void getStringInput(char operator[])
{
    printf("* Please type in the first string for the calculation:\n");
    printf("./CALCULATOR/%s", operator);
    scanf("%s", strinput1);

    printf("* Please type in the second string for the calculation:\n");
    printf("./CALCULATOR/%s", operator);
    scanf("%s", strinput2);

    printf("* Read numbers: %f %f", input1, input2);
}

float addition(float num1, float num2)
{
    return num1 + num2;
}

float subtraction(float num1, float num2)
{
    return num1 - num2;
}

float multiplication(float num1, float num2)
{
    return num1 * num2;
}

float division(float num1, float num2)
{
    return num1 / num2;
}

int modulo(float num1, float num2)
{
    int mod1 = (int)num1;
    int mod2 = (int)num2;
    return mod1 % mod2;
}

float increment(float num)
{
    return num++;
}

float decrement(float num)
{
    return num--;
}