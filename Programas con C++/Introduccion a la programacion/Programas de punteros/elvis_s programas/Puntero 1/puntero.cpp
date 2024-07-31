#include <iostream>

void imprimeChars( const char * ); // prototipo

//Un puntero no constante a un dato constante
 main ()
{
    char cFrase[] = "Hola Mundo";
    imprimeChars( cFrase );
}

void imprimeChars( const char *ptrStr )
{
    for ( ; *ptrStr != '\0'; ptrStr++ ) //Sin inicialización
        std::cout << *ptrStr;
}


