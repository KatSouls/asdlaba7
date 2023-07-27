//эл. ассоциативного массива
class Node
{
    int key; // ключ (ключ -> хэш)
    int data; // данные (данные ~ ключ)
    Node(int key, int data)
    {
        this.data = data;
        this.key = key;
    }
};


//интерфейс ассоциативного массива
class HashMap
{
	final int step = 3; // коэффициент сдвига для линейного опробования
    int size;
    Node[] table;


    //хэш функция
    int hash_function(int key)
    {
        return key % size;
    }


    //линейного опробования
    int re_hashing(int index)
    {
        return (index + step) % size;
    }


    void setSize(int size) throws Exception
    {
        if (size <= 0)
        {
            throw new Exception("Не допустимый размер");
        }
        this.size = size;
    }


    


    HashMap(int size) throws Exception
    {
        setSize(size);
        table = new Node[size];
        for (int i = 0; i < size; i++)
            table[i] = null;
        //
    }


    void add(int key, int data) throws Exception {
        int index = hash_function(key);
        int count = 0;
        while (table[index] != null)
        {
            //перезапись эл.
            if (table[index].key == key)
            {
                table[index].data = data;
                return;
            }

            index = (index + step) % size;
            if (count == size)
            {
                throw new Exception("Хеш-таблица переполнена");
            }
            count++;
        }
        if (table[index] == null)
        {
            table[index] = new Node(key, data);
        }
    }


    Node get(int key) {
    int hash = hash_function(key);
    int count = 0;
    while (table[hash] != null && count < size) {
        count++;
        if (table[hash].key == key)
        return table[hash];
        hash = re_hashing(hash);
    }
    return null;
    }

    void printDev(){
        for (int i = 0; i < size; i++) {
            if(table[i] != null){
                System.out.printf("%s: %s\n",i,table[i].key);
            }
        }
    }


}