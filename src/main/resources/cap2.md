Aplicaciones de ejercicios del libro "Aprendizaje Estatico con aplicaciones en R"


http://www-bcf.usc.edu/~gareth/ISL/data.html

Capitulo 2, Ejercicio 8

a. Usar la funcion read.csv() para leer el archivo Callage.csv

    # Seteamos el directorio de trabajo en el lugar donde se encuentran los recursos
> setwd("~/development/scalanando/src/main/resources")

    # Leemos el archivo
> read.csv('College.csv')
    
    # de esta forma le damos un nombre, 
> college <- read.csv('College.csv')
    
    # La primera columna de la hoja de calculo, son los nombres de las universidades, si queremos trabajar con esta informacion
    
    # remove(objeto) -- para borrar
    # fix(objeto) -- para verlos
    
> rownames(college) = college[,1]    -- crea una nueva columna `row.names` , donde a cada fila le pone un nombre
    
    #Ahora pasaremos a eliminar la primera columna
    # row.names no es una columna de datos, pero es el nombre que R le va dar a cada Fila.
    
> college = college[,-1]
    
    # usamos summary() para producir una suma numerica de variables en el conjunto de datos.
    # esta funcion devuelve para cada columna, la siguiente informacion:
    # si la columna es booleana, suba todos los si, agrupa si y no, y los suma, en otro caso, calcula min, cuartiles max. 

> summary(college)
    
    Private     Apps               
    No :212     Min.   :   81   
    Yes:565     1st Qu.:  776   
                Median : 1558   
                Mean   : 3002   
                3rd Qu.: 3624   
                Max.   :48094  
    
    # usando pairs(collage) crea una matrix de dispersion (scatterplot) de las primeras 10 columnas, 
> dim(college) -   - devuelve las dimensiones,  [1] 777  18,
    # 777 filas, 18 columnas, 
    # 777 observaciones, 18 variables
    
> names(college) -- nos dice el nombre de las variables, (columnas)

> plot(college$Enroll, college$Apps) -- luego plotemos matrix de dispersion (scatterplot), de las variables que qeurramos

> hist(college$Enroll, col=2)  -- histograma, colo=2 igual a col="red"
        