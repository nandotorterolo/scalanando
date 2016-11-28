# Capitulo 3 -  Regresión lineal simple y múltiple


Usamos la funcion `library` para cargar librerias

MASS,  collecion de conjuntos y funciones. BOSTON DATA SET. 
ISLE, conjuntos de datos associados a este libro.

BOSTON Data set: http://lib.stat.cmu.edu/datasets/boston

> library(MASS)

> library(ISLR)    -- Introduction Static Learning with aplication R

si hay algun error al cargar la libreria es porque no esta instalada

> install.packages("ISLR")

> fix(Boston)
> names(Boston)

Variables in order:
* CRIM     per capita crime rate by town
* ZN       proportion of residential land zoned for lots over 25,000 sq.ft.
* INDUS    proportion of non-retail business acres per town
* CHAS     Charles River dummy variable (= 1 if tract bounds river; 0 otherwise)
* NOX      nitric oxides concentration (parts per 10 million)
* RM       average number of rooms per dwelling
* AGE      proportion of owner-occupied units built prior to 1940
* DIS      weighted distances to five Boston employment centres
* RAD      index of accessibility to radial highways
* TAX      full-value property-tax rate per $10,000
* PTRATIO  pupil-teacher ratio by town
* B        1000(Bk - 0.63)^2 where Bk is the proportion of blacks by town
* LSTAT    % lower status of the population
* MEDV     Median value of owner-occupied homes in $1000's
 

## Usando la funcion ln

Ajusta una regresion lineal simple, donde se debe indicar una respuesta y un predictor. La sintaxis basica es `lm(y~x,data)`

> lm.fit=lm(medv~lstat,data=Boston)

si queremos tener algo de informacion

> lm.fit

Call:
lm(formula = medv ~ lstat, data = Boston)

Coefficients:
(Intercept)        lstat  
      34.55        -0.95
      
Para informacion mas en detalle.


> summary(lm.fit)

Call:
lm(formula = medv ~ lstat, data = Boston)

Residuals:
    Min      1Q  Median      3Q     Max 
-15.168  -3.990  -1.318   2.034  24.500 

Coefficients:
            Estimate Std. Error t value Pr(>|t|)    
(Intercept) 34.55384    0.56263   61.41   <2e-16 ***
lstat       -0.95005    0.03873  -24.53   <2e-16 ***
---
Signif. codes:  0 ‘***’ 0.001 ‘**’ 0.01 ‘*’ 0.05 ‘.’ 0.1 ‘ ’ 1

Residual standard error: 6.216 on 504 degrees of freedom
Multiple R-squared:  0.5441,	Adjusted R-squared:  0.5432 
F-statistic: 601.6 on 1 and 504 DF,  p-value: < 2.2e-16

para ver que otra informacion podemos extraer.
> names(lm.fit)

[1] "coefficients"  "residuals"     "effects"       "rank"          "fitted.values" "assign"        "qr"           
[8] "df.residual"   "xlevels"       "call"          "terms"         "model"  


para extraer coefficients

> coef(lm.fit)
(Intercept)       lstat 
 34.5538409  -0.9500494 
> confint(lm.fit)
                2.5 %     97.5 %
(Intercept) 33.448457 35.6592247
lstat       -1.026148 -0.8739505

Para producir intervalos de confianza e intervalos de prediccion para el predictor `medv`, para dado un valor `lstat`
valores posibles para interval: 'arg' should be one of “none”, “confidence”, “prediction”

> predict(lm.fit, data.frame(lstat=(c(5,10,15))), interval = "confidence")
       fit      lwr      upr
1 29.80359 29.00741 30.59978
2 25.05335 24.47413 25.63256
3 20.30310 19.73159 20.87461

> predict(lm.fit, data.frame(lstat=(c(5,10,15))), interval = "prediction")
       fit       lwr      upr
1 29.80359 17.565675 42.04151
2 25.05335 12.827626 37.27907
3 20.30310  8.077742 32.52846








  