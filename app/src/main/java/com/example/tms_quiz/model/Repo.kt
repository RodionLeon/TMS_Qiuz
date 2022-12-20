package com.example.tms_quiz.model

import javax.inject.Inject

class Repo @Inject constructor(){
    val data = arrayListOf("Какого цвета звезды на флаге Новой Зеландии?",
        "В центре какого флага изображено 24-спицевое колесо Ашока",
        "Как называется культовое здание на камбоджийском флаге?",
        "Флаг какой страны содержит самую большую звезду из всех флагов мира?")
    val answersAsVariants = arrayListOf(
        arrayListOf("Белый","Красный","Синий","Желтый"),
        arrayListOf("Индия","Шри-Ланка","Бангладеш","Пакистан"),
        arrayListOf("Пагода Шве Дагон","Ангкор-Ват","Фусими Инари Тайша","Джокьякарта"),
        arrayListOf("Центральноафриканская Республика","Суринам","Мьянма","Йемен")
    )
    val answerId = arrayListOf(1,0,1,2)
}