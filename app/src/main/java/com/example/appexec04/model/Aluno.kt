package com.example.appexec04.model;

class Aluno (val nome: String, val notas: Array<Double>) {

    fun getMediaNotas(): Double? {
        return notas.average();
    }

    fun getMenorNota(): Double? {
        return notas.min();
    }

    fun getMaiorNota(): Double? {
        return notas.max();
    }
}