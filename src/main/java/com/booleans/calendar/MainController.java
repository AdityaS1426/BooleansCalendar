@RequestMapping(value = "/labs/Yasaswi/LinkedList", method = {RequestMethod.GET, RequestMethod.POST})
    public String LinkedList(@RequestParam(value = "add", required = false, defaultValue = "7") String add, Model model) {

        LinkedList list = new LinkedList(new int[]{9, 1, 8, 5, 2,3});

        int val = Integer.parseInt(add);

        list.addHead(val);

        model.addAttribute("linkedlist1", list.traverse().get(0));
        model.addAttribute("linkedlist2", list.traverse().get(1));
        model.addAttribute("linkedlist3", list.traverse().get(list.traverse().size()-1));
        model.addAttribute("linkedlist4", list.traverse());

        return "labs/Yasaswi/YasaswiLinkedList";
    }
