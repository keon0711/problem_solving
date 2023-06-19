def solution(today, terms, privacies):
    def is_expired(date):
        for i in range(3):
            if date[i] > today[i]:
                return False
            elif date[i] < today[i]:
                return True
            
        return True
    
    
    def plus_month(date, month):
        if date[1] + month > 12:
            date[0] += (date[1] + month - 1) // 12
            date[1] = 1 + (date[1] + month - 1) % 12
        else:
            date[1] += month
        
        return date
    
    today = list(map(int, today.split('.')))
    valid_period = {}
    for term in terms:
        t = term.split()
        valid_period[t[0]] = int(t[1])
        
    expire_date = []
    for privacy in privacies:
        date, terms_type = privacy.split()
        expire_date.append(plus_month(list(map(int, date.split('.'))), valid_period[terms_type]))
        
    result = []
    print(today)
    for i, e in enumerate(expire_date):
        print(i, e)
        if is_expired(e):
            result.append(i + 1)
    
    return result
        
        
    