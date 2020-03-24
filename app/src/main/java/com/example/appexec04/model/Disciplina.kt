package com.example.appexec04.model;


class Disciplina (val nome: String) {
    val alunos: MutableList<Aluno> = mutableListOf<Aluno>()

    fun adicionaAluno(a: Aluno) {
        alunos.add(a);
    }
}