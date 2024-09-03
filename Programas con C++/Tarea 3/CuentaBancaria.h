//
//  Header.h
//  Cuenta Bancaria
//
//  Created by Andrés Enrique Linares Félix on 15/09/12.
//  Copyright (c) 2012 Andrés Enrique Linares Félix. All rights reserved.
//

#ifndef Cuenta_Bancaria_Header_h
#define Cuenta_Bancaria_Header_h

#include <iostream>
using namespace std;

class CuentaBancaria
{
    protected:
    
        double balance;                             // balance de cuenta
    
    public:
        
        CuentaBancaria(double balanceInicial)       // constructor
        {
            balance = balanceInicial;
        }
    
    
        void deposito(double monto)                 // hace deposito
        {
            balance = balance + monto;
        }
    
    
        void retiro(double monto)                   // hace retiro
        {
            balance = balance - monto;
        }
    
    
        void despliega()                            // despliega balance
        {
            cout << "balance = " << balance << endl;
        }
};  //fin de la clase CuentaBancaria

#endif
