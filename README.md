# Самый классный минибанк

Этот проект является "Мини-банком", который  состоит из трёх компонентов:

- frontend
    - telegram-bot на java/kotlin
- middle-слой
    - java/kotlin-сервис
- backend
    - java/kotlin-сервис
 
## Установка клаcсоного минибанка

[Для установки жми](https://www.example.com)

## Схема работы классного минибанка

@startuml

actor "User" as front

participant "Frontend" as report
participant "Middle Java Service" as report2
database "Бэкэнд" as db

front -> report: Запрос пользователя
activate report

report -> report2: Передача запроса от пользователя
activate report2
report2 -> db:  Запрос в банк
activate db
db --> report2:  Ответ банка
deactivate db
report2 --> report: Ответ приложения
deactivate report2
report --> front: Ответ пользователю
deactivate report

@enduml
