#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define add "add"
#define sub "sub"
#define mul "mul"
#define div "div"
#define mod "mod"
#define inc "inc"
#define dec "dec"
#define cmp "cmp"
#define strc "strcmp"
#define stca "strcat"

//declare functions
void printMenu();
void getNumInput(char operator[]);
void getStringInput(char operator[]);
float addition(float num1, float num2);
float subtraction(float num1, float num2);
float multiplication(float num1, float num2);
float division(float num1, float num2);
int modulo(float num1, float num2);
float increment(float num);
float decrement(float num);
int compare (float num1, float num2);

//declare variables
bool isRunning;
bool isWrongCommand;
char input[50];
char inputExit[50];
float input1;
float input2;
char output;
char strinput1[50];
char strinput2[50];

int main()
{
    //Main program
    do
    {
        //initialize variables
        isRunning = true;
        isWrongCommand = false;

        printMenu();
        fflush(stdin);
        scanf("%s", &input);
        printf("* You chose: %s\n", input);

        if (strcmp(input, add) == 0)
        {
            getNumInput("addition");
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result of %f + %f : %f\n", input1, input2, addition(input1, input2));
            printf("* |___________________________________________________________________________|\n");
        }

        if (strcmp(input, sub) == 0)
        {
            getNumInput("subtraction");
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result of %f - %f : %f\n", input1, input2, subtraction(input1, input2));
            printf("* |___________________________________________________________________________|\n");
        }

        if (strcmp(input, mul) == 0)
        {
            getNumInput("multiplication");
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result of %f * %f : %f\n", input1, input2, multiplication(input1, input2));
            printf("* |___________________________________________________________________________|\n");
        }

        if (strcmp(input, div) == 0)
        {
            getNumInput("division");
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result of %f / %f : %f\n", input1, input2, division(input1, input2));
            printf("* |___________________________________________________________________________|\n");
        }

        if (strcmp(input, mod) == 0)
        {
            getNumInput("modulo");
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result of %f %% %f : %d\n", input1, input2, modulo(input1, input2));
            printf("* |___________________________________________________________________________|\n");
        }

       if (strcmp(input, inc) == 0)
       {
           printf("* Please type in a number to increment:\n");
           printf("./CALCULATOR/increment/");
           fflush(stdin);
           scanf("%f", &input1);
           printf("*  ___________________________________________________________________________ \n");
           printf("* | Increment of %f : %f\n", input1, increment(input1));
           printf("* |___________________________________________________________________________|\n");
       }

        if (strcmp(input, dec) == 0)
        {
            printf("* Please type in a number to decrement:\n");
            printf("./CALCULATOR/decrement/");
            fflush(stdin);
            scanf("%f", &input1);
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Decrement of %f : %f\n", input1, decrement(input1));
            printf("* |___________________________________________________________________________|\n");
        }

        if (strcmp(input, cmp) == 0)
        {
            getNumInput("compare");
            switch (compare(input1, input2))
            {
                case 1:
                    output = '<';
                    break;
                case 2:
                    output = '>';
                    break;
                case 3:
                    output = '=';
                    break;
                default:
                    break;
            }
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result: %f %c %f\n", input1, output ,input2);
            printf("* |___________________________________________________________________________|\n");
        }

        if (strcmp(input, strc) == 0)
        {
            getStringInput("string-compare");
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result of string-compare %s and %s : %d\n", strinput1, strinput2, strcmp(strinput1, strinput2));
            printf("* |___________________________________________________________________________|\n");
        }

        if (strcmp(input, stca) == 0)
        {
            getStringInput("string-chain");
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Result of string-chain  : %s\n", strcat(strinput1, strinput2));
            printf("* |___________________________________________________________________________|\n");
        }

        if (strcmp(input, "exit") == 0)
            isRunning = false;

        if (strcmp(input, add) != 0 && strcmp(input, sub) != 0 && strcmp(input, mul) != 0 && strcmp(input, div) != 0 && strcmp(input, mod) != 0 && strcmp(input, inc) != 0 && strcmp(input, dec) != 0 && strcmp(input, cmp) != 0 && strcmp(input, strc) != 0 && strcmp(input, stca) != 0 && isRunning)
        {
            printf("*  _______\n");
            printf("* | ERROR | Unknown command\n");
            printf("* |_______|\n");
            isWrongCommand = true;
        }

        if (!isWrongCommand && isRunning)
        {
            fflush(stdin);
            printf("*  ___________________________________________________________________________ \n");
            printf("* | Would you like to do more calculations or would you like to exit the      |\n");
            printf("* | program?                                                                  |\n");
            printf("* | do more calculations (cont)                                               |\n");
            printf("* | exit the program (exit)                                                   |\n");
            printf("* |___________________________________________________________________________|\n");
            printf("./CALCULATOR/exit/");
            fflush(stdin);
            scanf("%s", &inputExit);
            printf("* You chose: %s\n", inputExit);

            if (strcmp(inputExit, "cont") == 0)  //funktioniert
                isRunning = true;
            else if (strcmp(inputExit, "exit") == 0)  //funktioniert nicht - keine Ahnung warum
                isRunning = false;
            else
            {
                printf("*  _______\n");
                printf("* | ERROR | Unknown command\n");
                printf("* |_______|\n");
                isWrongCommand = true;
            }
        }

        if (!isRunning)
        {
            printf("*  ___________________________________________________________________________ \n");
            printf("* |                         Shutting down...                                  |\n");
            printf("* |___________________________________________________________________________|\n");
        }
    }
    while (isRunning);

    return 0;
}

void printMenu()
{
    //Main Menu user interface
    printf("   _____      _            _       _             \n");
    printf("  / ____|    | |          | |     | |            \n");
    printf(" | |     __ _| | ___ _   _| | __ _| |_ ___  _ __ \n");
    printf(" | |    / _` | |/ __| | | | |/ _` | __/ _ \\| '__|\n");
    printf(" | |___| (_| | | (__| |_| | | (_| | || (_) | |   \n");
    printf("  \\_____\\__,_|_|\\___|\\__,_|_|\\__,_|\\__\\___/|_|   \n");
    printf("*  ___________________________________________________________________________ \n");
    printf("* |                   Welcome to NSC Calculator 1.5!                          |\n");
    printf("* |                         Development Edition                               |\n");
    printf("* |___________________________________________________________________________|\n");
    printf("* |Please choose one of the following operations by typing their command in ()|\n");
    printf("* | addition + (add)                                                          |\n");
    printf("* | subtraction - (sub)                                                       |\n");
    printf("* | multiplication * (mul)                                                    |\n");
    printf("* | division / (div)                                                          |\n");
    printf("* | modulo %% (mod)                                                            |\n");
    printf("* | String compare (strcmp)                                                   |\n");
    printf("* | String chain (strcat)                                                     |\n");
    printf("* | increment ++ (inc)                                                        |\n");
    printf("* | decrement -- (dec)                                                        |\n");
    printf("* | compare ==, <, > (cmp)                                                    |\n");
    printf("* |___________________________________________________________________________|\n");
    printf("* | Type \"exit\" to quit the program                                           |\n");
    printf("* |___________________________________________________________________________|\n");
    printf("./CALCULATOR/");
}

void getNumInput(char operator[])
{
    printf("* Please type in the first number for the calculation:\n");
    printf("./CALCULATOR/%s/", operator);
    fflush(stdin);
    scanf("%f", &input1);

    printf("* Please type in the second number for the calculation:\n");
    printf("./CALCULATOR/%s/", operator);
    fflush(stdin);
    scanf("%f", &input2);
}

void getStringInput(char operator[])
{
    printf("* Please type in the first string for the calculation:\n");
    printf("./CALCULATOR/%s/", operator);
    fflush(stdin);
    scanf("%s", &strinput1);

    printf("* Please type in the second string for the calculation:\n");
    printf("./CALCULATOR/%s/", operator);
    fflush(stdin);
    scanf("%s", &strinput2);
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
    return ++num;
}

float decrement(float num)
{
    return --num;
}

int compare (float num1, float num2)
{
    /*
     * Wieso funktioniert das hier nicht?
     * Wieso returned ein char-funktion einen Integer-Wert??

    int ir1 = (int)num1;
    int ir2 = (int)num2;
    switch (ir1)
    {
        case ir1 < ir2:
            return "<";
            break;
        case num1 > num2:
            return ">";
            break;
        case num1 == num2:
            return "==";
            break;
        default:
            printf("*  _______\n");
            printf("* | ERROR | An unexpected error occurred\n");
            printf("* |_______|\n");
            return "!";
            break;
    }
     */
    if (num1 < num2)
        return 1;
    else if (num1 > num2)
        return 2;
    else if (num1 == num2)
        return 3;
    else
    {
        printf("*  _______\n");
        printf("* | ERROR | An unexpected error occurred\n");
        printf("* |_______|\n");
        return -1;
    }
}