class Solution {
    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    class LinkedNodeList{
        Node head;
        Node tail;
        LinkedNodeList(){
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }

        public void addToTail(Node node){
            Node temp = tail.prev;
            node.next = tail;
            tail.prev = node;
            temp.next = node;
            node.prev = temp;
        }

        public void removeExpiredHead(int index){
            while(head.next != tail && index >= head.next.key){
                Node temp = head.next.next;
                temp.prev = head;
                head.next = temp;
            }
        }

        public void removeTail(Node node){
            while(tail.prev != head && tail.prev.val <= node.val){
                Node temp = tail.prev.prev;
                temp.next = tail;
                tail.prev = temp;
            }
        }

        public int getMax(){
            return head.next.val;
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        LinkedNodeList list = new LinkedNodeList();
        for(int i=0; i < nums.length; i++){
            Node node = new Node(i, nums[i]);
            list.removeTail(node);
            list.addToTail(node);
            if(i + 1 >= k){
                list.removeExpiredHead(i-k);
                res[i+1-k] = list.getMax();
            }
        }
        return res;
    }
}