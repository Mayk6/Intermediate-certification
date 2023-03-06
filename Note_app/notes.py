import json
import os.path
import time


class Note:
    def __init__(self, id, title, body, create_date, update_date):
        self.id = id
        self.title = title
        self.body = body
        self.create_date = create_date
        self.update_date = update_date

    def __repr__(self):
        return f"Заметка <id={self.id}," \
               f"Заголовок='{self.title}'," \
               f"Тело='{self.body}'," \
               f"Дата создания={self.create_date}," \
               f"Дата изменения={self.update_date}>"


class NotesApp:
    def __init__(self, notes_file):
        self.notes_file = notes_file
        self.notes = self.load_notes()

    def load_notes(self):
        if os.path.exists(self.notes_file):
            with open(self.notes_file, "r") as file:
                notes_data = json.load(file)
                return [Note(**data) for data in notes_data]
        else:
            return []

    def save_notes(self):
        notes_data = [note.__dict__ for note in self.notes]
        with open(self.notes_file, "w") as file:
            json.dump(notes_data, file)

    def add_note(self):
        title = input("Введите заголовок заметки: ")
        body = input("Введите текст заметки: ")
        create_date = time.strftime("%Y-%m-%d %H:%M:%S")
        note = Note(
            id=len(self.notes) + 1,
            title=title,
            body=body,
            create_date=create_date,
            update_date=create_date,
        )
        self.notes.append(note)
        self.save_notes()
        print("Заметка успешно добавлена")

    def edit_note(self):
        note_id = int(input("Введите id заметки для редактирования: "))
        note = self.get_note_by_id(note_id)
        if note:
            title = input("Введите новый заголовок для заметки: ")
            body = input("Введите новый текст заметки: ")
            note.title = title or note.title
            note.body = body or note.body
            note.update_date = time.strftime("%Y-%m-%d %H:%M:%S")
            print("Заметка успешно обновлена!")
        else:
            print("Заметка с таким id не найдена.")

    def delete_note(self):
        note_id = int(input("Введите id заметки для удаления: "))
        note = self.get_note_by_id(note_id)
        if note:
            self.notes.remove(note)
            self.save_notes()
            print("Заметка успешно удалена!")
        else:
            print("Заметка с таким id не найдена.")

    def get_note_by_id(self, note_id):
        for note in self.notes:
            if note.id == note_id:
                return note
        return None

    def print_notes(self):
        for note in self.notes:
            print(f"ID: {note.id}")
            print(f"Заголовок: {note.title}")
            print(f"Текст: {note.body}")
            print(f"Дата создания: {note.create_date}")
            print(f"Дата последнего изменения: {note.update_date}")
            print("-" * 15)

    def run(self):
        print("Добро пожаловать в приложение заметки!")
        while True:
            print("Выберите желаемое действие")
            print("1. Посмотреть список заметок")
            print("2. Добавить заметку")
            print("3. Редактировать заметку")
            print("4. Удалить заметку")
            print("5. Выйти из приложения")

            choice = input("Введите номер действия: ")
            if choice == "1":
                self.print_notes()
            elif choice == "2":
                self.add_note()
            elif choice == "3":
                self.edit_note()
            elif choice == "4":
                self.delete_note()
            elif choice == "5":
                print("Спасибо за использование приложения!")
                break
            else:
                print("Ошибка: выберите действие из списка.")


if __name__ == "__main__":
    app = NotesApp("notes.json")
    app.run()
