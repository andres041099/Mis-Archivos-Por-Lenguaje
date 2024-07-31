#include <iostream>


main()                      /* ejemplo de uso de un puntero */
 
{
 
int index,*pt1,*pt2;
 
index = 39;                      /* cualquier valor numérico */
 
pt1 = &index;                   /* la dirección de index */
 
pt2 = pt1;
 
printf("El valor es  %d %d %d\n",index,*pt1,*pt2);
 
*pt1 = 13;           /* esto cambia el valor de index */
 
printf("El valor es %d %d %d\n",index,*pt1,*pt2);
 
}
