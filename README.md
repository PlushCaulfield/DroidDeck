**DroidDeck: Mali Fix**

Сборка [DroidDeck](https://github.com/ASEbrahim/DroidDeck) с форком моста [MaliBridge](https://github.com/ASEbrahim/MaliBridge), настроенным для **Samsung Galaxy A35 (Exynos 1380, Mali-G68)**. Цель: меньше фризов в Steam- и PC-играх на телефонах с Mali.

Это неофициальный форк. Все права и заслуги принадлежат оригинальному автору (ASEbrahim). Лицензия GPL-3.0 сохранена, исходный код открыт.

**• Что изменено в MaliBridge**

| Настройка | Было | Стало | Зачем |
|---|---|---|---|
| Распаковка BC-текстур | перекодирование на GPU | **только распаковка** | убирает долгие фризы при подгрузке текстур |
| Лимит перекодирования | выкл. | авто | защита по размеру GPU |
| Сборка шейдеров | синхронная | **в фоне** (`defer`, 2 потока) | игра не ждёт компиляции |
| Размер текстур BC | без ограничения | **не больше 512 px** | меньше памяти, нет вылетов из-за нехватки RAM |

• **Результат (Alice: Madness Returns, один телефон)**

| Версия | Фризов в минуту | Самый долгий фриз |
|---|---|---|
| Оригинал v0.5.5.3 | ~45 | 11,4 с |
| Эта сборка (malifix5) | ~7 | 1,6 с |

Игра стала играбельной: быстрее грузятся уровни, нет вылетов по памяти (проверено ~10 минут), мигание объектов почти не заметно.

## Установка

1. Скачай APK из [Releases](../../releases).
2. Установи поверх DroidDeck (идентификатор пакета не менялся: `com.droiddeck.launcher`).
3. Для лога фризов добавь в параметры запуска игры в Steam: `VKBRIDGE_HITCH_MS=150 %command%`.

• Где можно со мной связаться?
Мы можете мне написать в Telegram: t.me/PlushCaulfield
<img width="2340" height="1080" alt="Screenshot_20261108_162110_DroidDeck" src="https://github.com/user-attachments/assets/11d84236-6662-48c6-bfa3-5b69e20f2e0f" />
<img width="2340" height="1080" alt="Screenshot_20261108_162228_DroidDeck" src="https://github.com/user-attachments/assets/f89b2cd0-231b-4ac7-a7f1-95a27d87af9e" />
<img width="2340" height="1080" alt="Screenshot_20261108_162354_DroidDeck" src="https://github.com/user-attachments/assets/7258e987-23dc-45b1-aef9-bb139b28a8a1" />
<img width="2340" height="1080" alt="Screenshot_20261108_162505_DroidDeck" src="https://github.com/user-attachments/assets/39b2080d-bd42-4a8d-81f3-89be774d86d3" />
<img width="2340" height="1080" alt="Screenshot_20261107_094845_DroidDeck Mali" src="https://github.com/user-attachments/assets/bf75ab52-fc50-437b-a401-0671eabc6364" />
<img width="2340" height="1080" alt="Screenshot_20261107_122754_DroidDeck Mali" src="https://github.com/user-attachments/assets/9f68004c-d144-4d87-97aa-f40a6859fa85" />


Важно: Portal 2 лагает, я еще не нашёл причину. Если вы её сами найдёте, дайте знать! Также это все тестировали на Mali G68, работу на других GPU не гарантирую!
