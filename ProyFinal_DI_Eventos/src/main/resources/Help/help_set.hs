<?xml version="1.0" encoding='ISO-8859-1' ?>
<!DOCTYPE helpset
  PUBLIC "-//Sun Microsystems Inc.//DTD JavaHelp HelpSet Version 2.0//EN"
         "http://java.sun.com/products/javahelp/helpset_2_0.dtd">

<helpset version="2.0">
    <title>Ejemplo ayuda JavaHelp</title>
    <maps>
        <!-- Página por defecto al mostrar la ayuda -->
        <homeID>main</homeID> <!-- Cambiado a "main" asumiendo que es la página principal -->
        <mapref location="map_file.jhm"/>
    </maps>

    <!-- Vista de Tabla de Contenidos -->
    <view>
        <name>Tabla Contenidos</name>
        <label>Tabla de contenidos</label>
        <type>javax.help.TOCView</type>
        <data>toc.xml</data>
    </view>

    <!-- Vista de Índice -->
    <view>
        <name>Indice</name>
        <label>El indice</label>
        <type>javax.help.IndexView</type>
        <data>indice.xml</data>
    </view>

    <!-- Vista de Búsqueda -->
    <view>
        <name>Buscar</name>
        <label>Buscar</label>
        <type>javax.help.SearchView</type>
        <data engine="com.sun.java.help.search.DefaultSearchEngine">
            JavaHelpSearch
        </data>
    </view>
</helpset>